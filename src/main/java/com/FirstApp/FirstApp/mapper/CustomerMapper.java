package com.FirstApp.FirstApp.mapper;
import com.FirstApp.FirstApp.dto.CustomerDto;
import com.FirstApp.FirstApp.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getCreated()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getPhone(),
                customerDto.getCreated()
        );
    }

}
