package com.example.seminar.product.controller;

import com.example.seminar.product.entity.Product;
import com.example.seminar.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/jpa")
    public List<Product> getTop10ProductsByPrice() {
        return productService.getTop10ProductsByPrice();
    }

    @GetMapping("/jpql")
    public List<Product> getTop5ProductsByStockAndPrice() {
        return productService.getTop5ProductsByStockAndPrice();
    }
}
