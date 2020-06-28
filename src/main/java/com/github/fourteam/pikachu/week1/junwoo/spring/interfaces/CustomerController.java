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

    @GetMapping("/Customer")
    public List<Customer> list() {
        final List<Customer> customerList = customerService.getCustomers();

        return customerList;
    }

    @GetMapping("/Customer/{id}")
    public Customer detail(@PathVariable String id) {
        final Customer customer = customerService.getCustomer(id);

        return customer;
    }

    @PostMapping("/Customer")
    public ResponseEntity<?> create(@RequestBody Customer customer) throws URISyntaxException {
        final String userId = customer.getUserId();
        final Integer point = customer.getPoint();
        final Role role = customer.getRole();

        Customer customer1 = new Customer(userId, role, point);

        URI location = new URI("/Customer/mike6321");//+customer1.getUserId());
        ResponseEntity.created(location).body("{1234}");
        return ResponseEntity.created(location).body("{1234}");
    }
}
