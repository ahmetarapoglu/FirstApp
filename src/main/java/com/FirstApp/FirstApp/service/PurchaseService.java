package com.FirstApp.FirstApp.service;
import com.FirstApp.FirstApp.model.PurchaseRequest;
import com.FirstApp.FirstApp.entity.Purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PurchaseService {
     Purchase createPurchaseTransaction(PurchaseRequest purchaseRequest);
     List<Purchase> getPurchasesByDate(LocalDateTime startDate , LocalDateTime endDate);
}
