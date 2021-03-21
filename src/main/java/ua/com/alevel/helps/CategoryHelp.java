package ua.com.alevel.helps;

import ua.com.alevel.connectionDB.DBConnector;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.model.Category;

import java.util.Scanner;

public class CategoryHelp {

    public static void createCategory(DBConnector dbConnector){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter category name:");
        String name = scanner.nextLine();
        Category category = CategoryDao.bildCategory(name);
        CategoryDao.InsertNewCategory(dbConnector,category);
    }

}
