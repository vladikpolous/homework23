package ua.com.alevel.helps;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.Category;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;

import java.util.List;
import java.util.Scanner;

public class ProductHelp {
    public static void createProduct(DBConnector dbConnector, Scanner scanner){
        System.out.println("Please, enter product name:");
        String name = scanner.nextLine();
        System.out.println("Please, enter " + name +"'s" +" price:");
        Double price = scanner.nextDouble();
        System.out.println("Please, enter category id:");
        int categoryid = scanner.nextInt();
        Product product = ProductDao.buildProduct(categoryid,name,price);
        ProductDao.InsertNewUser(dbConnector,product);
    }
    public static void deleteProduct(DBConnector dbConnector, Scanner scanner){
        System.out.println("Please, enter product name:");
        String name = scanner.nextLine();
        ProductDao.deleteProduct(dbConnector,name);
    }
    public static  void showProducts(DBConnector dbConnector) {
        List<Product> products = ProductDao.getAll(dbConnector);
        if (products.size() == 0) {
            System.out.println("There are no products in the database");
            return;
        }
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
