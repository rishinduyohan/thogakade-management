package edu.icet.repository;

import edu.icet.model.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {
    boolean addCustomer(CustomerDTO customer) throws SQLException;
    boolean updateCustomer(String id,CustomerDTO customer) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;
    ResultSet getAllCustomers() throws SQLException;
}
