package edu.icet.repository;

import edu.icet.model.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    boolean addCustomer(CustomerDTO customer) throws SQLException;
    boolean updateCustomer(CustomerDTO customer);
    boolean deleteCustomer(String id);
    ResultSet getAllCustomers() throws SQLException;
}
