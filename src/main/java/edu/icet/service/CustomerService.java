package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface CustomerService {
    boolean addCustomer(CustomerDTO customer);
    boolean updateCustomer(String id,CustomerDTO customer);
    boolean deleteCustomer(String id);
    ObservableList<CustomerDTO> getAllCustomers();
}
