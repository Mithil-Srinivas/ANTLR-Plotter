package com.example.calc;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class PlotterFX {
    private LineChart<Number, Number> chart;
    private Map<String, XYChart.Series<Number, Number>> seriesMap = new HashMap<>();

    public PlotterFX(LineChart<Number, Number> chart) {
        this.chart = chart;
    }

    public void addPlot(String title, double[] xs, double[] ys, String color) {
        Platform.runLater(() -> {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(title);

            for (int i = 0; i < xs.length; i++) {
                if (Double.isFinite(ys[i])) {
                    series.getData().add(new XYChart.Data<>(xs[i], ys[i]));
                }
            }

            chart.getData().add(series);

            // Wait until JavaFX applies CSS, then override color
            Platform.runLater(() -> {
                String cssColor = normalizeColor(color);
                if (series.getNode() != null) {
                    series.getNode().lookup(".chart-series-line")
                            .setStyle("-fx-stroke: " + cssColor + "; -fx-stroke-width: 2px;");
                }
                // Change legend symbol too
                var symbol = chart.lookup(".chart-legend-item-symbol");
                if (symbol != null)
                    symbol.setStyle("-fx-background-color: " + cssColor + ", white;");
            });
        });
    }

    private String normalizeColor(String color) {
        if (color == null || color.isBlank()) return "white";
        color = color.trim().toLowerCase();

        // allow hex colors
        if (color.startsWith("#")) return color;

        // allow color names
        switch (color) {
            case "red": case "green": case "blue": case "yellow":
            case "cyan": case "magenta": case "white": case "black":
            case "orange": case "pink": case "gray": case "purple":
                return color;
            default:
                return "white";
        }
    }


    public void clearPlots() {
        Platform.runLater(() -> chart.getData().clear());
    }
}
