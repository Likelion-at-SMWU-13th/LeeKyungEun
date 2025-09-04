package com.example.seminar.product.service;

import com.example.seminar.product.entity.Product;
import com.example.seminar.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getTop10ProductsByPrice() {
        return productRepository.findTop10ByOrderByPriceDesc();
    }

    public List<Product> getTop5ProductsByStockAndPrice() {
        return productRepository.getTop5ProductsByStockAndPrice(PageRequest.of(0, 5));
    }

}
