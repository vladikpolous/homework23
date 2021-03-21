package ua.com.alevel.helps;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.User;

import java.util.Scanner;

public class UserHelp {

    public static void createUser(DBConnector dbConnector, Scanner scanner){
        String nickname = scanner.nextLine();
        String email = scanner.nextLine();
        String adress = scanner.nextLine();
        User user = UserDao.bildUser(nickname,email,adress);
        UserDao.InsertNewUser(dbConnector,user);
    }

    public static void deleteUser(DBConnector dbConnector, Scanner scanner){
        String nickname = scanner.nextLine();
        UserDao.DeleteUser(dbConnector,nickname);
    }
}
