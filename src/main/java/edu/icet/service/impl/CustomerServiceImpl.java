package edu.icet.service.impl;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.repository.CustomerRepository;
import edu.icet.repository.impl.CustomerRepositoryImpl;
import edu.icet.service.CustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        try {
            if (customerRepository.addCustomer(customer)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(String id,CustomerDTO customer) {
        try {
            if (customerRepository.updateCustomer(id,customer)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        try {
            if (customerRepository.deleteCustomer(id)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomers() {
        ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = customerRepository.getAllCustomers();
            if (resultSet!=null) {
                while (resultSet.next()) {
                    customerDTOS.add(new CustomerDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    ));
                }
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return customerDTOS;
    }
}
