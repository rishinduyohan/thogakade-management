package edu.icet.service.impl;

import edu.icet.model.dto.ItemDTO;
import edu.icet.repository.ItemRepository;
import edu.icet.repository.impl.ItemRepositoryImpl;
import edu.icet.service.ItemService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository = new ItemRepositoryImpl();

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        try {
            if (itemRepository.addItem(itemDTO)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean updateItem(String id, ItemDTO itemDTO) {
        try {
            if (itemRepository.updateItem(id,itemDTO)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        try {
            if (itemRepository.deleteItem(id)){
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        return false;
    }

    @Override
    public ObservableList<ItemDTO> getAllItems() {
        ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList();
        try {
            ResultSet rst = itemRepository.getAllItems();
            if (rst!=null) {
                while (rst.next()) {
                    itemDTOS.add(new ItemDTO(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getDouble(5),
                            rst.getInt(4)
                    ));
                }
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
        return itemDTOS;
    }
}
