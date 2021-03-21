package ua.com.alevel.model;

public class Product {
    public int productId;
    public String name;
    public double price;
    public int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Product(){}
    Product(int productId, String name, double price, Category category){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   /* public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }*/
}
