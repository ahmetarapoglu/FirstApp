package com.FirstApp.FirstApp.repository;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RefundRepository extends JpaRepository<Refund, Long> {
    List<Refund> findByCreatedBetween(LocalDateTime startDate , LocalDateTime endDate);
}
