package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.CustomerRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:04 오후
 */
@Service
public class CustomerService {


    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String id) {
        Customer customer = customerRepository.findById(id);

        return customer;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers;
    }

    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }
}
