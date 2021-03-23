package ua.com.alevel.dao;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String INSERT_NEW_USER = "Insert into users(nickname,email,adress) VALUE (?,?,?);";
    private static final String DELETE_USER = "DELETE from users where nickname = ?;";
    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";

    public static void InsertNewUser(DBConnector dbConnector, User user) {
        PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_NEW_USER);

        try {
            statement.setString(1, user.nickname);
            statement.setString(2, user.email);
            statement.setString(3, user.adress);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    public static User getUserByEmail(DBConnector dbConnector, String email) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_USER_BY_EMAIL);
        try {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = UserDao.buildUser(resultSet);
            }
            return user;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
    private static User buildUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("userId"));
        user.setNickname(resultSet.getString("nickname"));
        user.setAdress(resultSet.getString("adress"));
        user.setEmail(resultSet.getString("email"));

        return user;
    }
    public static void DeleteUser(DBConnector dbConnector, String nickname){
        PreparedStatement statement = dbConnector.getPreparedStatement(DELETE_USER);

        try {
            statement.setString(1,nickname);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static User bildUser(String nickname, String email, String address){
        User user = new User();
        user.setNickname(nickname);
        user.setAdress(address);
        user.setEmail(email);
        return user;

    }
}
