package com.bakery.bakery_management.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date(); // Khud hi current date aur time save kar lega

    @Column(name = "totalAmount")
    private double totalAmount;

    // Yahan hum Customer table se isko connect kar rahe hain (Foreign Key)
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private customer customer;

    // Getters
    public int getOrderId() { return orderId; }
    public Date getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public customer getCustomer() { return customer; }

    // Setters
    public void setOrderId(int id) { this.orderId = id; }
    public void setOrderDate(Date date) { this.orderDate = date; }
    public void setTotalAmount(double amount) { this.totalAmount = amount; }
    public void setCustomer(customer cust) { this.customer = cust; }
}

