package edu.icet.repository;

import edu.icet.model.dto.ItemDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    boolean addItem(ItemDTO itemDTO);
    boolean updateItem(String id,ItemDTO itemDTO);
    boolean deleteItem(String id);
    ResultSet getAllItems() throws SQLException;
}
