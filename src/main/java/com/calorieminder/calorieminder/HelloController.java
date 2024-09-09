package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.USDAApi;
import com.calorieminder.calorieminder.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;


public class HelloController {
    public static String[] searchResults;
    @FXML
    private TextField searchBar;
    public static User user = new User();
    @FXML
    private Label welcomeText;
    //OUTDATED
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to CalorieMinder!");
    }

    //BUTTON TRANSITION FUNCTIONS
    @FXML
    protected void moveToMainPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("macrosFrame.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToMicrosPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("microsFrame.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();

    }

    @FXML
    protected void moveToWaterPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("WaterInput.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        waterInputFrame waterFrame = main.getController();
        waterFrame.addUnits();
        currentWindow.show();
    }

    @FXML
    protected void moveToFoodPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("foodPage.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToIntroPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("CalorieMinderIntroPage.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToNewDayPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("Newday.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToWeightTrendPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("WeightTrend.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        weightTrendFrame weightTrendFrame = main.getController();
        weightTrendFrame.addData();
        currentWindow.show();
    }

    @FXML
    protected void moveToFoodSearchResultsPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("SearchResults.fxml"));
        Scene scene = new Scene(main.load(), 725, 500);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    public void searchFood(ActionEvent actionEvent) throws IOException {
        USDAApi api = new USDAApi();
        try {
            String[] results = api.getFoodsStringByName(searchBar.getText());
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
            if (results.length == 0)
                System.out.println("EMPTY ARRAY");
            searchResults = results;
            moveToFoodSearchResultsPage(actionEvent);
        }
        catch (NullPointerException e) {
            searchBar.setText("ERROR: API KEY ISSUE");
            System.out.println("You are out of API Calls");
        }
    }


    //Possible transition function to cater to all pages rather than make multiple methods for one
    //protected void transitionToPage (ActionEvent event, String fxmlLink) throws IO Exception {}
}
