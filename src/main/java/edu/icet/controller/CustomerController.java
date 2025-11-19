package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.service.CustomerService;
import edu.icet.service.impl.CustomerServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    CustomerService customerService = new CustomerServiceImpl();
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private ComboBox<String> combProvince;

    @FXML
    private ComboBox<String> combTitle;

    @FXML
    private DatePicker dob;

    @FXML
    private TableView<CustomerDTO> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCusId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtSalary;

    private void generateNextCustomerId() {

    }

    private CustomerDTO getCurrentCustomer() {
        String cusId = txtCusId.getText();
        String title = combTitle.getValue();
        String name = txtName.getText();
        String date = String.valueOf(dob.getValue());
        String salary = txtSalary.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = combProvince.getValue();
        String postalCode = txtPostalCode.getText();
        return new CustomerDTO(cusId, title, name, date, Double.parseDouble(salary), address, city, province, postalCode);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (customerService.addCustomer(getCurrentCustomer())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Customer added!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (customerService.updateCustomer(txtCusId.getText(),getCurrentCustomer())){
            new Alert(Alert.AlertType.CONFIRMATION, "Customer updated!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
      if (customerService.deleteCustomer(txtCusId.getText())){
          new Alert(Alert.AlertType.INFORMATION, "Customer deleted!").show();
      }
      loadTable();
      btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCusId.setText("");
        combTitle.setValue("");
        txtName.setText("");
        dob.setValue(LocalDate.now());
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        combProvince.setValue("");
        txtPostalCode.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        loadTable();
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                txtCusId.setText(newValue.getId());
                combTitle.setValue(newValue.getTitle());
                txtName.setText(newValue.getName());
                dob.setValue(LocalDate.parse(newValue.getDob()));
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                combProvince.setValue(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
            }
        });

    }

    private void loadTable() {
        ObservableList<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        if (customerDTOS!=null) {
            tblCustomers.setItems(customerDTOS);
        }else{
            new Alert(Alert.AlertType.ERROR,"Customer details are empty!").show();
        }
    }

}