package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.model.dto.OrderDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface OrderService {
    boolean addOrder(OrderDTO order);
    boolean updateOrder(String id,OrderDTO order);
    boolean deleteOrder(String id);
    String getCustomerName(String id);
    ObservableList<String> getItemName(String id);
    ObservableList<String> getCustomerIdList();
    ObservableList<OrderDTO> getAllOrders();

}
