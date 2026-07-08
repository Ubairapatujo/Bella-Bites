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
    private Date orderDate = new Date();

    @Column(name = "totalAmount")
    private double totalAmount;

    @Column(name = "status")
    private String status = "Pending";

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private customer customer;

    @Column(name = "employeeId")
    private Integer employeeId;

    // Getters
    public int getOrderId() { return orderId; }
    public Date getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public customer getCustomer() { return customer; }
    public Integer getEmployeeId() { return employeeId; }

    // Setters
    public void setOrderId(int id) { this.orderId = id; }
    public void setOrderDate(Date date) { this.orderDate = date; }
    public void setTotalAmount(double amount) { this.totalAmount = amount; }
    public void setStatus(String status) { this.status = status; }
    public void setCustomer(customer customer) { this.customer = customer; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }
}