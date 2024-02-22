package com.FirstApp.FirstApp.repository;
import com.FirstApp.FirstApp.entity.Product;
import com.FirstApp.FirstApp.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
