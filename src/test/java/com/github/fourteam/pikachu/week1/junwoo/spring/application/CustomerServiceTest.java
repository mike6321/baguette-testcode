package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.CustomerRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:10 오후
 */
public class CustomerServiceTest {

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mockCustomer();

        customerService = new CustomerService(customerRepository);
    }

    private void mockCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("mike6321", Role.GENERAL,30);
        customers.add(customer);

        given(customerRepository.findAll()).willReturn(customers);
        given(customerRepository.findById("mike6321")).willReturn(customer);
    }

    @Test
    public void getCustomer() {
        Customer customer = customerService.getCustomer("mike6321");
        assertThat(customer.getUserId(),is("mike6321"));
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = customerService.getCustomers();
        Customer customer = customers.get(0);

        assertThat(customer.getPoint(),is(30));
    }

    @Test
    public void addCustomer() {

        Customer created = customerService.addCustomer(new Customer("jwdeveloper", Role.BLACKCONSUMER, 10000));
        assertThat(created.getUserId(), is("jwdeveloper"));
    }
}