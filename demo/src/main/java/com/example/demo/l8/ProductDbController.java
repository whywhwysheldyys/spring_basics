package com.example.demo.l8;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/l8/products")
public class ProductDbController {

    private final ProductRepository productRepository;

    public ProductDbController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
