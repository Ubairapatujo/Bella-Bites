package com.bakery.bakery_management.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class employee {

    @Id
    @Column(name = "employeeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private double salary;

    @Column(name = "username")
    private String username;

    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public String getUsername() { return username; }

    public void setEmployeeId(int id) { this.employeeId = id; }
    public void setEmployeeName(String name) { this.employeeName = name; }
    public void setRole(String role) { this.role = role; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setUsername(String username) { this.username = username; }
}