package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.ItemDTO;
import edu.icet.model.dto.OrderDTO;
import edu.icet.repository.OrderRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean addOrder(OrderDTO order) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("Insert into orders values(?,?,?)");
        statement.setObject(1,order.getOrderId());
        statement.setObject(2,order.getOrderDate());
        statement.setObject(3,order.getCustID());
        return statement.executeUpdate()>0;
    }

    @Override
    public boolean updateOrder(String id, OrderDTO order) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("Update orders set orderDate=?, custID=? where orderId='"+id+"'");
        statement.setObject(1,order.getOrderDate());
        statement.setObject(2,order.getCustID());
        return statement.executeUpdate()>0;
    }

    @Override
    public boolean deleteOrder(String id) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("Delete from orders where orderID='"+id+"'");
        return statement.executeUpdate()>0;
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
