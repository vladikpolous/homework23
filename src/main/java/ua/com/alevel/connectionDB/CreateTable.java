package ua.com.alevel.connectionDB;

public class CreateTable {
    /*
    Create table Categories(
categoryId int AUTO_INCREMENT,
name varchar(255) NOT NULL,
PRIMARY KEY (categoryId)
)
*/

    /*
    Create table Products(
productId int auto_increment,
name varchar(255) NOT NULL,
price int NOT NULL,
categoryId int NOT NULL,
PRIMARY KEY (productId),
FOREIGN KEY(categoryid) references categories(categoryId)
)*/

/*
* Create table Users(
userId int auto_increment,
nickname varchar(255) NOT NULL,
email varchar(255) NOT NULL,
PRIMARY KEY (userId)
)*/

    /*
    *Create table Orders(
orderId int auto_increment,
userId int NOT NULL,
productID int NOT NULL,
quantity int NOT NULL,
orderTime date NOT NULL,
PRIMARY KEY (orderId),
FOREIGN KEY(productID) references Products(productID),
FOREIGN KEY(userId) references Users(userId)
)*/
}
