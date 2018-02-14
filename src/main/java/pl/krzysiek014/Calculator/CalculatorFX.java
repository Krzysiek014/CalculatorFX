package pl.krzysiek014.Calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Krzysiek014 on 13.02.2018.
 */
public class CalculatorFX extends Application{
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        AnchorPane layout = FXMLLoader.load(ClassLoader.getSystemResource("WindowStyle.fxml"));
        Scene scene  = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("CalculatorFX");
        primaryStage.show();
    }
}
