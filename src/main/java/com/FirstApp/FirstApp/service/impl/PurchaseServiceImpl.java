package com.FirstApp.FirstApp.service.impl;
import com.FirstApp.FirstApp.model.PurchaseRequest;
import com.FirstApp.FirstApp.entity.Customer;
import com.FirstApp.FirstApp.entity.Product;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.exception.ResourceNotFoundException;
import com.FirstApp.FirstApp.repository.CustomerRepository;
import com.FirstApp.FirstApp.repository.ProductRepository;
import com.FirstApp.FirstApp.repository.PurchaseRepository;
import com.FirstApp.FirstApp.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Override
    public Purchase createPurchaseTransaction(PurchaseRequest purchaseRequest) {

        Customer customer =  customerRepository.findById(purchaseRequest.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer Not exists With given id." + purchaseRequest.getCustomerId()));

        Product product =  productRepository.findById(purchaseRequest.getProductId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product Not exists With given id." + purchaseRequest.getProductId()));

        Purchase purchase = new Purchase();

        purchase.setCustomer(customer);
        purchase.setProduct(product);
        purchase.setAmount(purchaseRequest.getAmount());

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getPurchasesByDate(LocalDateTime startDate , LocalDateTime endDate) {
        return purchaseRepository.findByCreatedBetween(startDate ,endDate);
    }

}
