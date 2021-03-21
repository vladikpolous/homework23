package ua.com.alevel.model;

import java.time.LocalDate;

public class Order {
    public int orderId;
    public  User user;
    public  Product product;
    public int quantity;
    public LocalDate orderTime;

    Order(int orderId, User user, Product product, int quantity, LocalDate orderTime){
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

    public LocalDate getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDate orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
