package ua.com.alevel;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.helps.CategoryHelp;
import ua.com.alevel.helps.OrderHelp;
import ua.com.alevel.helps.ProductHelp;
import ua.com.alevel.helps.UserHelp;
import ua.com.alevel.model.Category;

import java.util.Scanner;

public class App {
    static final String CREATE_CATEGORY = "Create category";
    static final String CREATE_PRODUCT = "Create product";
    static final String DELETE_PRODUCT = "Delete product";
    static final String CREATE_ORDER = "Create order";
    static final String DELETE_ORDER = "Delete order";
    static final String CREATE_USER = "Create user";
    static final String DELETE_USER = "Delete user";
    public static void main(String[] args) {

        DBConnector dbConnector = new DBConnector();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want?");
        String choice = scanner.nextLine();
        switch (choice) {
            case CREATE_CATEGORY:
                CategoryHelp.createCategory(dbConnector,scanner);
                break;
            case  CREATE_USER:
                UserHelp.createUser(dbConnector,scanner);
                break;
            case DELETE_USER:
                UserHelp.deleteUser(dbConnector,scanner);
                break;
            case CREATE_PRODUCT:
                ProductHelp.createProduct(dbConnector,scanner);
                break;
            case DELETE_PRODUCT:
                ProductHelp.deleteProduct(dbConnector,scanner);
                break;
            case CREATE_ORDER:
                OrderHelp.createOrder(dbConnector,scanner);
                break;
            case DELETE_ORDER:
                OrderHelp.deleteOrder(dbConnector,scanner);
                break;
            default:
                System.out.println("Something went wrong!!!");

        }


    }
}
