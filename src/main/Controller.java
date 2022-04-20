package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    static MySql mySql=new MySql();


    @FXML
    TextField emailTF,usernameTF,passwordTF,userNameMain;
    @FXML
    PasswordField passwordMain;

    @FXML
    private void createUser(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getClassLoader().getResource("resources/createFrame.fxml"));
        Scene scene= new Scene(parent);
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private  void backToHome(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getClassLoader().getResource("resources/mainFrame.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
private  void logIn(ActionEvent actionEvent) throws SQLException, IOException {
        Parent parent=FXMLLoader.load(getClass().getClassLoader().getResource("resources/loginFrame.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=(Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        if(mySql.verify(userNameMain.getText(),passwordMain.getText())){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("LogIn Successfully!");
            alert.setHeaderText(null);
            alert.showAndWait();
            stage.setScene(scene);
            stage.show();

        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please verify you username and password!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

}
}
