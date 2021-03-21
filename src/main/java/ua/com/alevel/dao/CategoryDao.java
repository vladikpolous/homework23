package ua.com.alevel.dao;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.model.Category;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {
    public static final String INSERT_NEW_CATEGORY = "Insert into Categories (name) VALUE (?);";

    public static void InsertNewCategory(DBConnector dbConnector, Category category) {
        PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_NEW_CATEGORY);
        try {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static Category bildCategory(String name){
        Category category = new Category();
        category.setName(name);
        return category;
    }
}
