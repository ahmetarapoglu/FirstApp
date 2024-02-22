package com.FirstApp.FirstApp.repository;
import com.FirstApp.FirstApp.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByCreatedBetween(LocalDateTime startDate , LocalDateTime endDate);
}
