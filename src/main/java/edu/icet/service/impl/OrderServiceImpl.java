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

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();
    ObservableList<String> customers = FXCollections.observableArrayList();
    ObservableList<OrderDTO> orderDTOS = FXCollections.observableArrayList();

    @Override
    public boolean addOrder(OrderDTO order) {
        try {
            if (orderRepository.addOrder(order)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean updateOrder(String id, OrderDTO order) {
        try {
            if (orderRepository.updateOrder(id,order)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean deleteOrder(String id) {
        try {
            if (orderRepository.deleteOrder(id)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return false;
    }
    @Override
    public String getCustomerName(String id) {
        try {
            ResultSet resultSet = orderRepository.getCustomer(id);
            if (resultSet!=null){
                while(resultSet.next()) {
                   return resultSet.getString(3);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Empty customer";
    }
    @Override
    public ObservableList<String> getItemName(String id) {
        return null;
    }

    @Override
    public ObservableList<String> getCustomerIdList() {
        customers.clear();
        try {
            ResultSet resultSet = orderRepository.getCustomerList();
            if (resultSet!=null){
                while (resultSet.next()){
                    customers.add(
                           resultSet.getString(1)
                   );
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return customers;
    }

    @Override
    public ObservableList<OrderDTO> getAllOrders() {
        orderDTOS.clear();
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
