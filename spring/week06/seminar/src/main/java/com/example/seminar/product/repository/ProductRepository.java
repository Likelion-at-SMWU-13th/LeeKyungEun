package com.example.seminar.product.repository;

import com.example.seminar.product.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop10ByOrderByPriceDesc();

    @Query("SELECT p FROM Product p WHERE p.price <= 2000 ORDER BY p.stock DESC")
    List<Product> getTop5ProductsByStockAndPrice(Pageable pageable);
}
