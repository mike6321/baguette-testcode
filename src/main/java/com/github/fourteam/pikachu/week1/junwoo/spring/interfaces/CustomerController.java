package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.CustomerService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:01 오후
 */
@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> list() {
        final List<Customer> customerList = customerService.getCustomers();

        return customerList;
    }

    @GetMapping("/customer/{id}")
    public Customer detail(@PathVariable String id) {
        final Customer customer = customerService.getCustomer(id);

        return customer;
    }

    @PostMapping("/customer")
    public ResponseEntity<?> create(@RequestBody Customer customer) throws URISyntaxException {
        final String userId = customer.getUserId();
        final Integer point = customer.getPoint();
        final Role role = customer.getRole();

        Customer customer1 = new Customer(userId, role, point);

        customerService.addCustomer(customer1);

        URI location = new URI("/customer/mike6321");//+customer1.getUserId());
        ResponseEntity.created(location).body("{1234}");
        return ResponseEntity.created(location).body("{1234}");
    }
}
// http POST localhost:8080/customer userId=mike6321 role=GENERAL point=30
// http GET localhost:8080/customer
