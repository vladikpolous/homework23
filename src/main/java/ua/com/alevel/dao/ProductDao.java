package ua.com.alevel.dao;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.model.Category;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String INSERT_NEW_PRODUCT = "Insert into products (name,price,categoryId) VALUE (?,?,?);";
    private static final String DELETE_PRODUCT = "DELETE from products where name = ?;";
    private static final String SHOW_PRODUCTS = "SELECT * FROM products";
    private static final String GET_PRODUCT_BY_NAME = "SELECT * FROM products where name = ?";
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
    public static Product getProductByName(DBConnector dbConnector, String name) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_PRODUCT_BY_NAME);
        try {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                product = buildProduct(dbConnector, resultSet);
            }
            return product;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public static List<Product> getAll(DBConnector dbConnector) {
        final ResultSet resultSet = dbConnector.executeQuery(SHOW_PRODUCTS);

        return processResult(dbConnector, resultSet);
    }
    private static Product buildProduct(DBConnector dbConnector, ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("productId"));
        product.setName(resultSet.getString("name"));
        product.setPrice(Double.parseDouble(resultSet.getString("price")));
        int categoryId = resultSet.getInt("categoryId");
        product.setCategoryId(categoryId);

        return product;
    }
    private static List<Product> processResult(DBConnector dbConnector, ResultSet resultSet) {
        List<Product> products = new ArrayList<>();

        try {
            while (resultSet.next()) {
                products.add(buildProduct(dbConnector, resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return products;
    }


    public static Product buildProduct(int categoryId, String name, double price) {
        Product product = new Product();
        product.setCategoryId(categoryId);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
