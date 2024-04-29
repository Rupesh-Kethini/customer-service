package com.hotel.customerservice.repository;

import com.hotel.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmailAndPassword(String emailId, String password);
}