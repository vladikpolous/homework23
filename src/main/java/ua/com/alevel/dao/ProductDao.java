package ua.com.alevel.dao;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.model.Category;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {
    private static final String INSERT_NEW_PRODUCT = "Insert into products (name,price,categoryId) VALUE (?,?,?);";
    private static final String DELETE_PRODUCT = "DELETE from products where name = ?;";
    public static void InsertNewUser(DBConnector dbConnector, Product product) {
        PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_NEW_PRODUCT);

        try {
            statement.setString(1, product.name);
            statement.setDouble(2, product.price);
            statement.setInt(3, product.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public static void deleteProduct(DBConnector dbConnector, String name) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(DELETE_PRODUCT);
        try {
            statement.setString(1, name);
            statement.executeUpdate();

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static Product buildProduct(int categoryId, String name, double price) {
        Product product = new Product();
        product.setCategoryId(categoryId);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
