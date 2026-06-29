package com.bakery.bakery_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private int orderDetailId;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private orders order; // Yahan lowercase orders bilkul sahi hai

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "product_id")
    private product product; // Yahan lowercase product bilkul sahi hai

    // Getters aur Setters
    public int getOrderDetailId() { return orderDetailId; }
    public int getQuantity() { return quantity; }
    public orders getOrder() { return order; }
    public product getProduct() { return product; }

    public void setOrderDetailId(int id) { this.orderDetailId = id; }
    public void setQuantity(int qty) { this.quantity = qty; }
    public void setOrder(orders order) { this.order = order; }
    public void setProduct(product prod) { this.product = prod; }
}