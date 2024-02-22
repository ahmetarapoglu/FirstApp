package com.FirstApp.FirstApp.service;

import com.FirstApp.FirstApp.dto.RefundDto;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.entity.Refund;
import com.FirstApp.FirstApp.model.PurchaseRequest;
import com.FirstApp.FirstApp.model.RefundRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface RefundService {

     RefundDto createRefundTransaction(RefundRequest refundRequest);
     List<Refund> getRefundsByDate(LocalDateTime startDate , LocalDateTime endDate);

}
