package edu.icet.repository;

import edu.icet.model.dto.ItemDTO;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {
    boolean addItem(ItemDTO itemDTO) throws SQLException;
    boolean updateItem(String id,ItemDTO itemDTO) throws SQLException;
    boolean deleteItem(String id) throws SQLException;
    ResultSet getAllItems() throws SQLException;
}
