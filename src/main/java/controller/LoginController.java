package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Validation;

import java.io.IOException;

public class LoginController {
    @FXML
    Button login_button;
    @FXML
    Button register_button;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label login_error;

    public void onLoginButtonClick(ActionEvent actionEvent) {
        if (Validation.isValidUsername(username.getText()) && Validation.isValidPassword(password.getText())) {
            goToDashboard(actionEvent);
        } else {
            login_error.setText("Wrong username or password");
        }
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/register.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene((root), 550, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToDashboard(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/userdashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 800));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
