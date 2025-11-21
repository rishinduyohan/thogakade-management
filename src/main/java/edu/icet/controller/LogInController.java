package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController extends Component implements Initializable {
    Stage stage = new Stage();
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
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard_form.fxml"))));
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Dashboard Form");
        stage.show();
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
        signUpPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginPane.setVisible(true);
        signUpPane.setVisible(false);
    }
}
