package edu.icet.repository;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.ItemDTO;
import edu.icet.model.dto.OrderDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepository {
    boolean addOrder(OrderDTO order) throws SQLException;
    boolean updateOrder(String id,OrderDTO order) throws SQLException;
    boolean deleteOrder(String id) throws SQLException;
    ResultSet getCustomer(String id) throws SQLException;
    ResultSet filterItemCode(String id) throws SQLException;
    ResultSet getItems(String id);
    ResultSet getCustomerList() throws SQLException;
    ResultSet getAllOrders() throws SQLException;
}
