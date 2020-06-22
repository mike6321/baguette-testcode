package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImpossibleOrderCustomerTest {
    private Customer customer;

    @Before
    public void setUp () {
        customer = ImpossibleOrderCustomer.builder().build();
    }

    @Test
    public void 주문가능상태_확인() {
        boolean isPassed = customer.checkCustomerStatus();

        assertFalse(isPassed);
    }

}