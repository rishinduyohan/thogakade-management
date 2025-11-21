package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.OrderDTO;
import edu.icet.service.OrderService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@RequiredArgsConstructor
public class OrderController implements Initializable {

    private final OrderService orderService;

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

    private OrderDTO getCurrentOrder(){
        String orderid = txtOrderId.getText();
        String date = String.valueOf(dateOrder.getValue());
        String cusId = cmbCustomerId.getValue();
        return new OrderDTO(orderid,date,cusId);
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        loadTable();
        tblOrders.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                txtOrderId.setText(newValue.getOrderId());
                dateOrder.setValue(LocalDate.parse(newValue.getOrderDate()));
                cmbCustomerId.setValue(newValue.getCusId());
            }
        });
    }
    private void loadTable(){
        ObservableList<OrderDTO> orderDTOS = orderService.getAllOrders();
        if (orderDTOS!=null) {
            tblOrders.setItems(orderDTOS);
        }else{
            new Alert(Alert.AlertType.ERROR,"Order details are empty!").show();
        }
    }
}
