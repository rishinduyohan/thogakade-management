package edu.icet.db;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private Connection connection;
    private static DBConnection instance;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/thogakade", "root", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DBConnection getInstance() {
        return instance == null ? new DBConnection() : instance;
    }
}
