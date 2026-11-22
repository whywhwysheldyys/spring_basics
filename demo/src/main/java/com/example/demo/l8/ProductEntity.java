package com.example.demo.l8;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;
    private String category;
    private int quantity;

    public ProductEntity() {

    }

    public ProductEntity(String title, double price, String category) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
