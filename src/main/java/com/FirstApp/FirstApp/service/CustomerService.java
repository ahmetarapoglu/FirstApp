package com.FirstApp.FirstApp.service;
import com.FirstApp.FirstApp.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto getCustomerById(Long customerId);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer);
    void deleteCustomer(Long customerId);
}
