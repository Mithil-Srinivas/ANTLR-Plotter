package com.example.calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.antlr.v4.runtime.*;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import javafx.scene.input.ScrollEvent;
import java.io.File;


public class CalculatorApp extends Application {
    private StringBuilder consoleOutput = new StringBuilder();
    private TextArea console;
    private PlotterFX plotter;
    private TextArea codeArea;
    private EvalVisitor visitor; // <-- persist visitor across lines

    @Override
    public void start(Stage stage) {
        // ----------- Left Panel: Code Editor + Console -----------
        codeArea = new TextArea();
        codeArea.setPromptText("Write your expressions here...\nExample:\n"
                + "x = 2\n"
                + "f(x) = sin(x)\n"
                + "plot(f(x), -3.14, 3.14, \"red\")\n"
                + "plot(cos(x), -3.14, 3.14, \"blue\")");
        codeArea.setWrapText(true);
        codeArea.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 13px;");

        console = new TextArea();
        console.setId("console");
        console.setEditable(false);
        console.setPrefHeight(150);
        console.setStyle("-fx-font-family: 'Consolas'; -fx-font-size: 12px;");

        Button runBtn = new Button("Run All");
        Button clearPlotBtn = new Button("Clear Plot");
        Button saveSessionBtn = new Button("Save Session");
        Button loadSessionBtn = new Button("Load Session");
        Button savePlotBtn = new Button("Save Plot");
        Button resetZoomBtn = new Button("Reset Zoom");

        saveSessionBtn.getStyleClass().add("save-button");
        loadSessionBtn.getStyleClass().add("load-button");
        savePlotBtn.getStyleClass().add("save-button");
        resetZoomBtn.getStyleClass().add("run-button");
        runBtn.getStyleClass().add("run-button");
        clearPlotBtn.getStyleClass().add("clear-button");



        HBox buttonBar = new HBox(10, runBtn, clearPlotBtn, savePlotBtn, resetZoomBtn, saveSessionBtn, loadSessionBtn);
        buttonBar.setPadding(new Insets(5));

        VBox leftPane = new VBox(10, new Label("Editor:"), codeArea,
                new Label("Console Output:"), console, buttonBar);
        leftPane.setPadding(new Insets(10));
        leftPane.setPrefWidth(400);

        // ----------- Right Panel: Plot Area -----------
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);

        // ========== Button Actions ==========
        savePlotBtn.setOnAction(e -> savePlot(chart));
        resetZoomBtn.setOnAction(e -> resetZoom(xAxis, yAxis));

// These two use the same EvalVisitor instance
        saveSessionBtn.setOnAction(e -> {
            if (visitor != null) visitor.saveSession("session.json");
            else console.appendText("No session to save yet.\n");
        });

        loadSessionBtn.setOnAction(e -> {
            if (visitor != null) visitor.loadSession("session.json");
            else {
                visitor = new EvalVisitor(plotter, consoleOutput);
                visitor.loadSession("session.json");
            }
            console.appendText("Session loaded.\n");
        });


        final double[] zoomFactor = {1.0};
        chart.addEventFilter(ScrollEvent.SCROLL, e -> {
            if (e.getDeltaY() == 0) return;
            double factor = (e.getDeltaY() > 0) ? 0.9 : 1.1;
            zoomFactor[0] *= factor;
            xAxis.setAutoRanging(false);
            yAxis.setAutoRanging(false);
            double rangeX = xAxis.getUpperBound() - xAxis.getLowerBound();
            double rangeY = yAxis.getUpperBound() - yAxis.getLowerBound();
            double midX = (xAxis.getUpperBound() + xAxis.getLowerBound()) / 2;
            double midY = (yAxis.getUpperBound() + yAxis.getLowerBound()) / 2;
            double newRangeX = rangeX * factor;
            double newRangeY = rangeY * factor;
            xAxis.setLowerBound(midX - newRangeX / 2);
            xAxis.setUpperBound(midX + newRangeX / 2);
            yAxis.setLowerBound(midY - newRangeY / 2);
            yAxis.setUpperBound(midY + newRangeY / 2);
            e.consume();
        });

// Panning
        final double[] dragStart = new double[2];
        chart.setOnMousePressed(e -> {
            dragStart[0] = e.getX();
            dragStart[1] = e.getY();
        });
        chart.setOnMouseDragged(e -> {
            double deltaX = (e.getX() - dragStart[0]);
            double deltaY = (e.getY() - dragStart[1]);
            double shiftX = deltaX / chart.getWidth() * (xAxis.getUpperBound() - xAxis.getLowerBound());
            double shiftY = deltaY / chart.getHeight() * (yAxis.getUpperBound() - yAxis.getLowerBound());
            xAxis.setAutoRanging(false);
            yAxis.setAutoRanging(false);
            xAxis.setLowerBound(xAxis.getLowerBound() - shiftX);
            xAxis.setUpperBound(xAxis.getUpperBound() - shiftX);
            yAxis.setLowerBound(yAxis.getLowerBound() + shiftY);
            yAxis.setUpperBound(yAxis.getUpperBound() + shiftY);
            dragStart[0] = e.getX();
            dragStart[1] = e.getY();
        });

        chart.setTitle("Plot Area");
        chart.setCreateSymbols(false);
        chart.setAnimated(false);
        chart.setLegendVisible(true);
        plotter = new PlotterFX(chart);

        // ----------- Root Layout -----------
        SplitPane root = new SplitPane(leftPane, chart);

// Make both halves equal on startup
        root.setDividerPositions(0.5);

// Keep equal width on resize
        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            root.setDividerPositions(0.5);
        });


        Scene scene = new Scene(root, 1000, 650);
        scene.getStylesheets().add(getClass().getResource("/CalculatorApp.css").toExternalForm());

        stage.setTitle("ANTLR Calculator + Plotter GUI");
        stage.setScene(scene);
        stage.show();

        // ----------- Event Handlers -----------
        runBtn.setOnAction(e -> runCode());
        clearPlotBtn.setOnAction(e -> plotter.clearPlots());

        // Run on Ctrl+Enter for convenience
        codeArea.setOnKeyPressed(e -> {
            if (e.isControlDown() && e.getCode() == KeyCode.ENTER) {
                runCode();
                e.consume();
            }
        });
    }

    private void runCode() {
        consoleOutput.setLength(0);
        if (visitor == null) visitor = new EvalVisitor(plotter, consoleOutput);

        String[] lines = codeArea.getText().split("\\n");
        for (String line : lines) {
            String text = line.trim();
            if (text.isEmpty()) continue;

            try {
                CharStream input = CharStreams.fromString(text);
                ExprLexer lexer = new ExprLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                ExprParser parser = new ExprParser(tokens);
                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                            int line, int charPositionInLine, String msg, RecognitionException e) {
                        throw new RuntimeException("Syntax error: " + msg);
                    }
                });

                var tree = parser.prog();
                visitor.visit(tree); // ✅ reuse persistent visitor
            } catch (Exception ex) {
                consoleOutput.append("Error: ").append(ex.getMessage()).append("\n");
            }
        }

        console.appendText(consoleOutput.toString());
    }

    private void savePlot(LineChart<Number, Number> chart) {
        try {
            var image = chart.snapshot(null, null);

            // Get the directory where the JAR is located
            String jarDir = new File(CalculatorApp.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI())
                    .getParent();

            File outFile = new File(jarDir, "plot.png");
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outFile);

            console.appendText("Plot saved to: " + outFile.getAbsolutePath() + "\n");
        } catch (Exception ex) {
            console.appendText("Error saving plot: " + ex.getMessage() + "\n");
        }
    }


    private void resetZoom(NumberAxis xAxis, NumberAxis yAxis) {
        xAxis.setAutoRanging(true);
        yAxis.setAutoRanging(true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
