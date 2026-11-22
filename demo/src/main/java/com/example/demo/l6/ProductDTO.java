package com.example.demo.l6;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    @NotBlank(message = "Введите название товара")
    @Size(min = 3, max = 50, message = "Введите название товара от 3 до 50 символов")
    private String title;

    @DecimalMin(value = "0.01", message = "Цена должна быть больше нуля")
    private double price;

    @NotBlank(message = "Введите категорию товара")
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}