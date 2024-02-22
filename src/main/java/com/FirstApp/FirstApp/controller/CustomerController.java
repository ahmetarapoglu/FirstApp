package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.global.Roles;
import com.FirstApp.FirstApp.dto.CustomerDto;
import com.FirstApp.FirstApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){

        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long customerId){

        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customerDto);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){

        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable("id") Long customerId,
            @RequestBody CustomerDto updatedCustomer){
        CustomerDto customerDto = customerService.updateCustomer(customerId ,updatedCustomer);

        return ResponseEntity.ok(customerDto);
    }

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully!.");
    }

}


