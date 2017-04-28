package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("sample.fxml"));
        Scene scena = new Scene(loader.load());
        primaryStage.setTitle("Kalkulator");
        primaryStage.setScene(scena);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
