package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.CustomerDTO;
import edu.icet.repository.CustomerRepository;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public boolean addCustomer(CustomerDTO newCustomer) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("Insert into customer values(?,?,?,?,?,?,?,?,?)");
        statement.setObject(1, newCustomer.getId());
        statement.setObject(2, newCustomer.getTitle());
        statement.setObject(3, newCustomer.getName());
        statement.setObject(4, newCustomer.getDob());
        statement.setObject(5, newCustomer.getSalary());
        statement.setObject(6, newCustomer.getAddress());
        statement.setObject(7, newCustomer.getCity());
        statement.setObject(8, newCustomer.getProvince());
        statement.setObject(9, newCustomer.getPostalCode());
        return 0 < statement.executeUpdate();
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Statement statement = DBConnection.getInstance().getConnection().createStatement();
        return statement.executeQuery("Select * From Customer");

    }
}
