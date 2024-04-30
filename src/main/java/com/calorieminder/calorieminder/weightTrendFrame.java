package com.calorieminder.calorieminder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class weightTrendFrame extends HelloController {
    @FXML
    private LineChart<Double, Double> weightChart;

    @FXML
    protected void addData() {

        XYChart.Series series = new XYChart.Series();
        series.setName("Weight Trend Graph");

        for(int i = 0; i < user.getWeightList().size(); i++)
        {
            series.getData().add(new XYChart.Data(Integer.toString(i), user.getWeightList().get(i)));
        }
        weightChart.getData().add(series);
        weightChart.getXAxis().setAnimated(false);
    }


    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }
}
