package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainClass extends Application {
    public static void main(String[] args) throws SQLException {
        launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene= new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("resources/mainFrame.fxml")));
        stage.setScene(scene);
        stage.show();
    }
}
