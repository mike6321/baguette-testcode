package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:55 오후
 */
public class CustomerRepositoryTest {


    @Test
    public void information() {
        Customer customer = new Customer("mike6321", Role.GENERAL,30);
        //assertThat(customer.getRole(),is(Role.BLACKCONSUMER));
        assertThat(customer.getRole(),is(Role.GENERAL));
        assertThat(customer.getUserId(),is("mike6321"));
        assertThat(customer.getPoint(),is(30));


    }
}