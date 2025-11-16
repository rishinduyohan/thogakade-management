package edu.icet.controller.mainController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {
    Stage stage = new Stage();

    @FXML
    private AnchorPane mainContent;

    private void setUi(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
            Parent loadedUi = loader.load();

            mainContent.getChildren().clear();
            mainContent.getChildren().add(loadedUi);

            AnchorPane.setLeftAnchor(loadedUi, 0.0);
            AnchorPane.setRightAnchor(loadedUi, 0.0);
            AnchorPane.setTopAnchor(loadedUi, 0.0);
            AnchorPane.setBottomAnchor(loadedUi, 0.0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) {
        setUi("/view/Customer_form.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemsOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Login_form.fxml"))));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Login Form");
        stage.show();
    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {

    }

}
