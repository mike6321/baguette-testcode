package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import static org.junit.Assert.*;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

public class NormalCustomerTest {
    private Customer customer;

    @Before
    public void setUp () {
        customer = NormalCustomer.builder().build();
    }

    @Test
    public void 주문가능상태_확인(){
        boolean isPassed = customer.checkCustomerStatus();

        assertTrue(isPassed);
    }

}