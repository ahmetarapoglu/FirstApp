package com.FirstApp.FirstApp.repository;
import com.FirstApp.FirstApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
