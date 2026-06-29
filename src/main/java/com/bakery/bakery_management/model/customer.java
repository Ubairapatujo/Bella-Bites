package com.bakery.bakery_management.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Customer", catalog = "BakeryManagement", schema = "dbo")
public class customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    // Getters
    public int getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public String getPhone() { return phone; }

    // Setters
    public void setCustomerId(int id) { this.customerId = id; }
    public void setFullName(String name) { this.fullName = name; }
    public void setPhone(String phone) { this.phone = phone; }
}
