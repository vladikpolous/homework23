package ua.com.alevel.model;

import java.sql.Timestamp;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    public int orderId;
    public  User user;
    public  Product product;
    public int quantity;
    public Timestamp orderTime;

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Order(){}

    Order(int orderId, User user, Product product, int quantity, Timestamp orderTime){
        this.orderId = orderId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
