package edu.icet.controller.mainController;

import edu.icet.model.dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

// 1. You would replace 'CustomerModel' with your actual DAO/service logic
// 2. You would replace 'CustomerDTO' with your actual data transfer object class

public class CustomerController {

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextField txtContact;

    @FXML private TableView<CustomerDTO> tblCustomers;
    @FXML private TableColumn<CustomerDTO, String> colId;
    @FXML private TableColumn<CustomerDTO, String> colName;
    @FXML private TableColumn<CustomerDTO, String> colAddress;
    @FXML private TableColumn<CustomerDTO, String> colContact;

    // This will be called automatically when the FXML is loaded
    public void initialize() {
        // 1. Initialize the TableView columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        loadAllCustomers();

        // 2. Add Listener to TableView to populate form when a row is selected
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateCustomerForm(newSelection);
            }
        });

        // 3. Generate initial ID
        generateNextCustomerId();
    }

    private void generateNextCustomerId() {
        // Implement logic to get the next sequential ID from the database
        // For now, we'll use a placeholder:
        // txtId.setText(customerModel.getNextId());
        txtId.setText("C001");
    }

    private void populateCustomerForm(CustomerDTO customer) {
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtContact.setText(customer.getContact());
        // Set ADD button to disabled and enable UPDATE/DELETE if needed
    }

    private void loadAllCustomers() {
        // Implement database fetching logic here
        // ObservableList<CustomerDTO> customers = customerModel.getAllCustomers();

        // Placeholder data:
        ObservableList<CustomerDTO> customers = FXCollections.observableArrayList(
                new CustomerDTO("C001", "Alice Johnson", "123 Main St", "077-1234567"),
                new CustomerDTO("C002", "Bob Williams", "456 Oak Ave", "071-9876543")
        );

        tblCustomers.setItems(customers);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        // 1. Get data from text fields
        // 2. Validate data
        // 3. Call customerModel.save(new CustomerDTO(...))
        // 4. Show success alert and reload table
        new Alert(Alert.AlertType.INFORMATION, "Customer saved!").show();
        btnNewOnAction(null); // Clear form and refresh
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        // 1. Get data from text fields (including ID)
        // 2. Validate data
        // 3. Call customerModel.update(updatedCustomerDTO)
        // 4. Show success alert and reload table
        new Alert(Alert.AlertType.INFORMATION, "Customer updated!").show();
        btnNewOnAction(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        // 1. Get ID from txtId
        // 2. Show confirmation dialog
        // 3. If confirmed, call customerModel.delete(id)
        // 4. Show success alert and reload table
        new Alert(Alert.AlertType.INFORMATION, "Customer deleted!").show();
        btnNewOnAction(null);
    }

    @FXML
    void btnNewOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        tblCustomers.getSelectionModel().clearSelection();
        generateNextCustomerId();
        loadAllCustomers();
    }
}