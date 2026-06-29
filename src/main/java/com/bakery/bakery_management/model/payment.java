package com.bakery.bakery_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Payment")
public class payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;

    @Column(name = "paymentMode") // Cash, Card, ya EasyPaisa/JazzCash
    private String paymentMode;

    @Column(name = "status")      // Paid ya Pending
    private String status;

    // Relationship: Ye payment kis order ki hai
    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private orders order;

    // Getters
    public int getPaymentId() { return paymentId; }
    public String getPaymentMode() { return paymentMode; }
    public String getStatus() { return status; }
    public orders getOrder() { return order; }

    // Setters
    public void setPaymentId(int id) { this.paymentId = id; }
    public void setPaymentMode(String mode) { this.paymentMode = mode; }
    public void setStatus(String status) { this.status = status; }
    public void setOrder(orders order) { this.order = order; }
}
