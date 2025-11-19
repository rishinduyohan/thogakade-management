package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.ItemDTO;
import edu.icet.repository.ItemRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public boolean addItem(ItemDTO itemDTO) {
        return false;
    }

    @Override
    public boolean updateItem(String id, ItemDTO itemDTO) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public ResultSet getAllItems() throws SQLException {
        Statement statement = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = statement.executeQuery("SELECT * FROM item");
        return rst;
    }
}
