package edu.icet.repository.impl;

import edu.icet.db.DBConnection;
import edu.icet.model.dto.ItemDTO;
import edu.icet.repository.ItemRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public boolean addItem(ItemDTO newItem) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO ITEM VALUES(?,?,?,?,?)");
        statement.setObject(1, newItem.getItemCode());
        statement.setObject(2, newItem.getDescription());
        statement.setObject(3, newItem.getPackSize());
        statement.setObject(5, newItem.getUnitPrice());
        statement.setObject(4, newItem.getQtyOnHand());
        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean updateItem(String id, ItemDTO currentItem) throws SQLException {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("UPDATE ITEM SET description=?,packSize=?,unitPrice=?,qtyOnHand=? WHERE itemCode='"+id+"'");
        statement.setObject(1, currentItem.getDescription());
        statement.setObject(2, currentItem.getPackSize());
        statement.setObject(4, currentItem.getUnitPrice());
        statement.setObject(3, currentItem.getQtyOnHand());
        return statement.executeUpdate() > 0;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        int res = stm.executeUpdate("DELETE FROM item WHERE itemCode='"+ id +"'");
        return res > 0;
    }

    @Override
    public ResultSet getAllItems() throws SQLException {
        Statement statement = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = statement.executeQuery("SELECT * FROM item");
        return rst;
    }
}
