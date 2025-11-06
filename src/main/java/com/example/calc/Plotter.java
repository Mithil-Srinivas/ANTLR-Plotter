package com.example.calc;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Utility to show a simple line plot using JavaFX.
 * showPlot is non-blocking (it opens a window on the JavaFX thread).
 */
public class Plotter {
    // ensure JavaFX platform is initialized
    private static volatile boolean javafxInited = false;
    private static final Object initLock = new Object();

    private static void initJavaFx() {
        if (javafxInited) return;
        synchronized (initLock) {
            if (javafxInited) return;
            // creates JFXPanel which initializes JavaFX runtime
            new JFXPanel();
            javafxInited = true;
        }
    }

    /**
     * Show plot given xs and ys (same length). title used for window title.
     */
    public static void showPlot(double[] xs, double[] ys, String title) {
        initJavaFx();
        Platform.runLater(() -> {
            try {
                NumberAxis xAxis = new NumberAxis();
                NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("x");
                yAxis.setLabel("y");

                LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
                lineChart.setTitle("Plot: " + title);

                XYChart.Series<Number, Number> series = new XYChart.Series<>();
                series.setName("f(x)");

                for (int i = 0; i < xs.length; ++i) {
                    if (Double.isNaN(ys[i])) continue;
                    series.getData().add(new XYChart.Data<>(xs[i], ys[i]));
                }

                lineChart.getData().add(series);
                lineChart.setCreateSymbols(false);

                Stage stage = new Stage();
                stage.setTitle("Plot - " + title);
                Scene scene = new Scene(lineChart, 800, 600);
                stage.setScene(scene);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
