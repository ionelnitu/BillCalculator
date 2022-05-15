package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller extends MySql{


    @FXML
    Label userName;
    @FXML
    TextField emailTF, usernameTF, passwordTF, userNameMain,pcs,priceKwh,oldIndexTF,newIndexTF,priceElecTF,oldIndexElTF,newIndexElTF;
    @FXML
    PasswordField passwordMain;


    @FXML
    private void createUserFrame(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/createFrame.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backToHome(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/mainFrame.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void logIn(ActionEvent actionEvent) throws SQLException, IOException {
        Person person=new Person(userNameMain.getText(),passwordMain.getText());
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/loginFrame.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        if (verify(person.getEmail(),person.getPassword())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("LogIn Successfully!");
            alert.setHeaderText(null);
            alert.showAndWait();
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please verify you username and password!");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

    }

    @FXML
    private void create(ActionEvent actionEvent) throws IOException {
        try {
            insert(usernameTF.getText(), passwordTF.getText(), emailTF.getText());
            insertGas(pcs.getText(),priceKwh.getText(),Double.parseDouble(oldIndexTF.getText()),Double.parseDouble(newIndexTF.getText()));
            insertElectricity(Double.parseDouble(priceElecTF.getText()),Double.parseDouble(oldIndexElTF.getText()),Double.parseDouble(newIndexElTF.getText()));
            Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("resources/mainFrame.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please verify your data!");
            alert.showAndWait();
        }

    }
}
