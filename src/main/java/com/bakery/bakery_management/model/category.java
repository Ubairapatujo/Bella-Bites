package com.bakery.bakery_management.model;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    public int getCategoryId() { return categoryId; }
    public String getCategoryName() { return categoryName; }
    public String getDescription() { return description; }

    public void setCategoryId(int id) { this.categoryId = id; }
    public void setCategoryName(String name) { this.categoryName = name; }
    public void setDescription(String desc) { this.description = desc; }
}