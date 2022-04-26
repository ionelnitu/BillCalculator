package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainClass extends Application {
    public static void main(String[] args) throws SQLException {
        launch(args);


    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene= new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("resources/mainFrame.fxml")));
        stage.setTitle("Bill Calculator");
        stage.getIcons().add(new Image("resources/bill.png"));
        stage.setScene(scene);
        stage.show();
    }
}
