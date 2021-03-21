package ua.com.alevel.connectionDB;

import java.sql.*;

import static ua.com.alevel.connectionDB.ConnectionConst.*;

public class DBConnector {
    private final Connection connection;

    public DBConnector() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public ResultSet executeQuery(String query) {
        try {
            return connection.createStatement().executeQuery(query);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public int executeUpdate(String query) {
        try {
            return connection.createStatement().executeUpdate(query);
        } catch (SQLException sqlException) {
            System.out.println(query);
            throw new RuntimeException(sqlException);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
