package com.hotel.customerservice.service;

import com.hotel.customerservice.entity.Customer;
import com.hotel.customerservice.model.Credentials;
import com.hotel.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId, Customer customerDetails) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            Customer oldCustomer = customer.get();
            oldCustomer.setFirstName(customerDetails.getFirstName());
            oldCustomer.setLastName(customerDetails.getLastName());
            oldCustomer.setEmail(customerDetails.getEmail());
            return customerRepository.save(oldCustomer);
        }
        else
            return null;


    }

    public boolean deleteCustomer(Long customerId) {
        if(customerRepository.findById(customerId).isPresent()) {
            customerRepository.deleteById(customerId);
            return true;
        }
        else return false;
    }

    public Customer login(Credentials crdentials) {
        return customerRepository.findByEmailAndPassword(crdentials.getEmail(), crdentials.getPassword());
    }
}
