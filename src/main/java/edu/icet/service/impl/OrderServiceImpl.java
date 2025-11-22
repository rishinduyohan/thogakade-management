package edu.icet.service.impl;

import edu.icet.model.dto.OrderDTO;
import edu.icet.repository.OrderRepository;
import edu.icet.repository.impl.OrderRepositoryImpl;
import edu.icet.service.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

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
    public String getCustomerName(String id) {
        return "";
    }

    @Override
    public String getItemName(String id) {
        return "";
    }

    @Override
    public List<String> getCustomerIdList() {
        return List.of();
    }

    @Override
    public ObservableList<OrderDTO> getAllOrders() {
        ObservableList<OrderDTO> orderDTOS = FXCollections.observableArrayList();
        try {
            ResultSet rst = orderRepository.getAllOrders();
            if (rst!=null) {
                while (rst.next()) {
                    orderDTOS.add(new OrderDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3)
                    ));
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return orderDTOS;
    }
}
