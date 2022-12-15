package TargetHeartRateCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TargetHeartRateCalculatorMainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TargetHeartRateCalculator.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Target Heart Rate Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
