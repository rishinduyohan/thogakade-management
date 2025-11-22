package edu.icet.repository;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.ItemDTO;
import edu.icet.model.dto.OrderDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepository {
    boolean addOrder(OrderDTO order);
    boolean updateOrder(String id,OrderDTO order);
    boolean deleteOrder(String id);
    CustomerDTO getCustomers(String id);
    ItemDTO getItems(String id);
    ResultSet getCustomerIdList() throws SQLException;
    ResultSet getAllOrders() throws SQLException;
}
