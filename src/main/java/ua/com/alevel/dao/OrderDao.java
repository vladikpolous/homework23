package ua.com.alevel.dao;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.model.Order;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;

import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao {
    private static final String INSERT_NEW_ORDER = "INSERT INTO orders (productId, userId, quantity, orderTime) " +
            "VALUES (?, ?, ?, ?)";
    private static final String SHOW_ALL_ORDERS = "SELECT * FROM orders;";
    private static final String DELETE_ORDERS_BY_ID = "DELETE from orders where orderId = ?;";

    public static void insertOrder(DBConnector dbConnector, Order order) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_NEW_ORDER);
        try {
            statement.setLong(1, order.getProduct().getProductId());
            statement.setLong(2, order.getUser().getUserId());
            statement.setInt(3, order.getQuantity());
            statement.setTimestamp(4, order.getOrderTime());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public static void DeleteUser(DBConnector dbConnector, int orderId){
        PreparedStatement statement = dbConnector.getPreparedStatement(DELETE_ORDERS_BY_ID);

        try {
            statement.setInt(1,orderId);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public static Order buildOrder(Product product, User user, int count, Timestamp orderDate) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setQuantity(count);
        order.setOrderTime(orderDate);
        return order;
    }
}
