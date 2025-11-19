package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DashboardController {
    public Button btnDashboard;
    public Button btnCustomers;
    public Button btnItems;
    public Button btnOrders;
    public Button btnOrderDetails;

    Stage stage = new Stage();

    @FXML
    private AnchorPane mainContent;

    private final String ACTIVE_STYLE = "-fx-background-color: linear-gradient(to right, #22c55e, #16a34a); -fx-text-fill: white; -fx-background-radius: 10; -fx-font-size: 14px; -fx-alignment: CENTER_LEFT; -fx-padding: 0 0 0 20; -fx-cursor: hand;";

    private final String DEFAULT_STYLE = "-fx-background-color: #f9fafb; -fx-text-fill: #374151; -fx-background-radius: 10; -fx-font-size: 14px; -fx-alignment: CENTER_LEFT; -fx-padding: 0 0 0 20; -fx-cursor: hand; -fx-border-color: #e5e7eb; -fx-border-width: 1.5; -fx-border-radius: 10;";

    private void updateActiveButton(Button clickedButton) {
        List<Button> allButtons = Arrays.asList(btnDashboard, btnCustomers, btnItems, btnOrders, btnOrderDetails);

        for (Button btn : allButtons) {
            if (btn == clickedButton) {
                btn.setStyle(ACTIVE_STYLE);
            } else {
                btn.setStyle(DEFAULT_STYLE);
            }
        }
    }

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
        updateActiveButton(btnCustomers);
        setUi("/view/Customer_form.fxml");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        updateActiveButton(btnDashboard);
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard_form.fxml"))));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Dashboard Form");
        stage.show();
    }

    @FXML
    void btnItemsOnAction(ActionEvent event) {
        updateActiveButton(btnItems);
        setUi("/view/Item_form.fxml");
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
