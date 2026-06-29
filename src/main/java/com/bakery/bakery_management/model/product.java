package com.bakery.bakery_management.model;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_qty")
    private int stockQty;

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getStockQty() { return stockQty; }

    public void setProductId(int id) { this.productId = id; }
    public void setProductName(String name) { this.productName = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQty(int qty) { this.stockQty = qty; }
}