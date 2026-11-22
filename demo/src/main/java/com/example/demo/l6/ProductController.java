package com.example.demo.l6;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/l6/products")
    public String products(
            @Valid @RequestBody ProductDTO request
    ) {
        return "Товар " + request.getTitle()
                + " из категории " + request.getCategory()
                + " успешно добавлен по цене " + request.getPrice()
                + "!";
    }
}