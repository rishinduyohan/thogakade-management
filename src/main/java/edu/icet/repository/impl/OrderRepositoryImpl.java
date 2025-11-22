package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.ItemDTO;
import edu.icet.model.dto.OrderDTO;
import edu.icet.repository.OrderRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean addOrder(OrderDTO order) {
        return false;
    }

    @Override
    public boolean updateOrder(String id, OrderDTO order) {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        return false;
    }

    @Override
    public CustomerDTO getCustomers(String id) {
        return null;
    }

    @Override
    public ItemDTO getItems(String id) {
        return null;
    }

    @Override
    public ResultSet getCustomerIdList() throws SQLException {
        Statement statement = DBConnection.getInstance().getConnection().createStatement();
        return statement.executeQuery("Select * from customer");
    }

    @Override
    public ResultSet getAllOrders() throws SQLException {
        Statement statement = DBConnection.getInstance().getConnection().createStatement();
        return statement.executeQuery("Select * from orders");
    }
}
