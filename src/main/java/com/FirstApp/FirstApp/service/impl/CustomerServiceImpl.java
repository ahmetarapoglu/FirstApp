package com.FirstApp.FirstApp.service.impl;
import com.FirstApp.FirstApp.dto.CustomerDto;
import com.FirstApp.FirstApp.entity.Customer;
import com.FirstApp.FirstApp.exception.ResourceNotFoundException;
import com.FirstApp.FirstApp.mapper.CustomerMapper;
import com.FirstApp.FirstApp.repository.CustomerRepository;
import com.FirstApp.FirstApp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer =  customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer Not exists With given id." + customerId));

        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(CustomerMapper::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer) {

        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer Not exists With given id." + customerId));

        customer.setName(updatedCustomer.getName());
        customer.setPhone(updatedCustomer.getPhone());

        Customer updatedCustomerObj = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer =  customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer Not exists With given id." + customerId));

        customerRepository.deleteById(customerId);
    }

}
