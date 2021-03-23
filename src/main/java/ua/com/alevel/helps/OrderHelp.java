package ua.com.alevel.helps;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.dao.OrderDao;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.Order;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class OrderHelp {

    public static void createOrder(DBConnector dbConnector, Scanner scanner) {
        System.out.println("Enter a product's name from the list:");
        ProductHelp.showProducts(dbConnector);
        Product product = new Product();
        String productName = scanner.nextLine();
        product = ProductDao.getProductByName(dbConnector, productName);

        System.out.println("Enter the user's email who want to order");
        String email = scanner.nextLine();
        User user;
        user = UserDao.getUserByEmail(dbConnector, email);

        System.out.println("How many products you want to add to the order?");
        int count = scanner.nextInt();

        Timestamp orderTime = Timestamp.valueOf(LocalDateTime.now());

        Order order = OrderDao.buildOrder(product, user, count, orderTime);
        OrderDao.insertOrder(dbConnector, order);
    }
    public static void deleteOrder(DBConnector dbConnector, Scanner scanner){
        System.out.println("Please, enter orderId:");
        int orderId = scanner.nextInt();
        OrderDao.DeleteUser(dbConnector,orderId);
    }
}
