package com.FirstApp.FirstApp.service.impl;
import com.FirstApp.FirstApp.dto.RefundDto;
import com.FirstApp.FirstApp.entity.Customer;
import com.FirstApp.FirstApp.entity.Product;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.entity.Refund;
import com.FirstApp.FirstApp.exception.ResourceNotFoundException;
import com.FirstApp.FirstApp.mapper.ProductMapper;
import com.FirstApp.FirstApp.mapper.RefundMapper;
import com.FirstApp.FirstApp.model.RefundRequest;
import com.FirstApp.FirstApp.repository.CustomerRepository;
import com.FirstApp.FirstApp.repository.ProductRepository;
import com.FirstApp.FirstApp.repository.PurchaseRepository;
import com.FirstApp.FirstApp.repository.RefundRepository;
import com.FirstApp.FirstApp.service.RefundService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RefundServiceImpl implements RefundService {

    private PurchaseRepository purchaseRepository;
    private RefundRepository refundRepository;

    @Override
    public RefundDto createRefundTransaction(RefundRequest refundRequest) {

        Purchase purchase =  purchaseRepository.findById(refundRequest.getPurchaseId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Purchase Not exists With given id." + refundRequest.getPurchaseId()));

        Product Product = purchase.getProduct();
        Customer customer = purchase.getCustomer();

        Refund refund = new Refund();

        refund.setPurchase(purchase);
        refund.setCustomer(customer);
        refund.setProduct(Product);
        refund.setAmount(refundRequest.getAmount());

        refund = refundRepository.save(refund);

        return RefundMapper.mapToRefundDto(refund);
    }

    @Override
    public List<Refund> getRefundsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return refundRepository.findByCreatedBetween(startDate , endDate);
    }


}
