package edu.icet.controller.mainController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends Component implements Initializable {

    @FXML
    private CheckBox checkSelect;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private AnchorPane signUpPane;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtUsername1;

    public void userNameOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void checkPasswordOnAction(ActionEvent actionEvent) {
        btnLogInOnAction(actionEvent);
    }

    public void btnLogInOnAction(ActionEvent actionEvent) {
    }

    public void btnSignInOnAction(ActionEvent actionEvent) {
        signUpPane.setVisible(true);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        signUpPane.setVisible(false);
    }

    public void newUsernameOnAction(ActionEvent actionEvent) {
        txtPassword1.requestFocus();
    }

    public void checkSecondPasswordOnAction(ActionEvent actionEvent) {
        btnSignUpAction(actionEvent);
    }

    public void btnSignUpAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginPane.setVisible(true);
        signUpPane.setVisible(false);
    }
}
