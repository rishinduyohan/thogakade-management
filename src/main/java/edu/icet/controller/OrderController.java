package edu.icet.controller;

import edu.icet.model.dto.OrderDTO;
import edu.icet.service.OrderService;
import edu.icet.service.impl.OrderServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    Stage stage = new Stage();
    OrderService orderService = new OrderServiceImpl();

    @FXML
    private ComboBox<String> cmbCustomerId;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private DatePicker dateOrder;

    @FXML
    private AnchorPane orderPane;

    @FXML
    private TableView<OrderDTO> tblOrders;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtOrderDetails;

    @FXML
    private TextField txtOrderId;

    private OrderDTO getCurrentOrder() {
        String orderid = txtOrderId.getText();
        String date = String.valueOf(dateOrder.getValue());
        String cusId = cmbCustomerId.getValue();
        return new OrderDTO(orderid, date, cusId);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderId.setText("");
        dateOrder.setValue(LocalDate.now());
        cmbCustomerId.setValue("Select a customer");
        txtCustomerName.setText("");
        txtOrderDetails.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (orderService.deleteOrder(txtOrderId.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order deleted!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        if (orderService.addOrder(getCurrentOrder())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order added!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (orderService.updateOrder(txtOrderId.getText(), getCurrentOrder())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order updated!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custID"));
        loadTable();
        setCustomerIds();
        tblOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                txtOrderId.setText(newValue.getOrderId());
                dateOrder.setValue(LocalDate.parse(newValue.getOrderDate()));
                cmbCustomerId.setValue(newValue.getCustID());
                txtCustomerName.setText(orderService.getCustomerName(cmbCustomerId.getValue()));
            }
        });

    }

    private void loadTable() {
        ObservableList<OrderDTO> orderDTOS = orderService.getAllOrders();
        if (orderDTOS != null) {
            tblOrders.setItems(orderDTOS);
        } else {
            new Alert(Alert.AlertType.ERROR, "Order details are empty!").show();
        }
    }

    public void setCustomerIds() {
        cmbCustomerId.setItems(orderService.getCustomerIdList());
    }

    public void btnShowItemsOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Bill_form.fxml"))));
        } catch (IOException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        stage.setTitle("Bill print");
        stage.show();
    }

    public void cmdCustomerOnAction(ActionEvent actionEvent) {
        txtCustomerName.setText(orderService.getCustomerName(cmbCustomerId.getValue()));
    }

}
