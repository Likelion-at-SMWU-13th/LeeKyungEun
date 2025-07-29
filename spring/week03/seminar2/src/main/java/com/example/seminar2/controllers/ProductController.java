package com.example.seminar2.controllers;

import com.example.seminar2.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
