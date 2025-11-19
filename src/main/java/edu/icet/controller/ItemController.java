package edu.icet.controller;

import edu.icet.model.dto.ItemDTO;
import edu.icet.service.ItemService;
import edu.icet.service.impl.ItemServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    ItemService itemService = new ItemServiceImpl();
    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private AnchorPane itemPane;

    @FXML
    private TableView<ItemDTO> tblItems;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    public ItemDTO getCurrentItem(){
         String itemCode = txtItemCode.getText();
         String description = txtDescription.getText();
         String packSize = txtPackSize.getText();
         double unitPrice = Double.parseDouble(txtUnitPrice.getText());
         int qtyOnHand = Integer.parseInt(txtQty.getText());

         return new ItemDTO(itemCode,description,packSize,unitPrice,qtyOnHand);
    }
    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (itemService.addItem(getCurrentItem())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item added!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtItemCode.setText("");
        txtDescription.setText("");
        txtPackSize.setText("");
        txtUnitPrice.setText("");
        txtQty.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (itemService.deleteItem(txtItemCode.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item deleted!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (itemService.updateItem(txtItemCode.getText(),getCurrentItem())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Item updated!").show();
        }
        loadTable();
        btnClearOnAction(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        loadTable();
        tblItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                txtItemCode.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtPackSize.setText(newValue.getPackSize());
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
                txtQty.setText(String.valueOf(newValue.getQtyOnHand()));
            }
        });
    }
    private void loadTable(){
        ObservableList<ItemDTO> itemDTOS = itemService.getAllItems();
        if (itemDTOS!=null) {
            tblItems.setItems(itemDTOS);
        }else{
            new Alert(Alert.AlertType.ERROR,"Item details are empty!").show();
        }
    }
}
