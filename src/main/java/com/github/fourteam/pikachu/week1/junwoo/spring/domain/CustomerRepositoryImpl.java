package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:07 오후
 */
@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public CustomerRepositoryImpl() {
        customers.add(new Customer("mike6321", Role.GENERAL,30));
        customers.add(new Customer("bbubbush", Role.BLACKCONSUMER,3));
        customers.add(new Customer("ssinsa", Role.EXECUTIVES,10));
        customers.add(new Customer("mesung", Role.GENERAL,10));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String id) {
        return customers.stream()
                        .filter(r -> r.getUserId().equals(id))
                        .findFirst()
                        .orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);

        return customer;
    }
}
