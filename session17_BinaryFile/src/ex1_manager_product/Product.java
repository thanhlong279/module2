package ex1_manager_product;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String productName;
    private double price;
    private String producer;

    public Product(){
    }

    public Product(String id, String productName, double price, String producer) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.producer = producer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                '}';
    }
}
