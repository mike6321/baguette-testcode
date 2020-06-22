package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import static org.junit.Assert.*;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

public class NormalCustomerTest {
    @Test
    public void checkCustomerStatus_true() {
        // given
        Customer cunsumer = NormalCustomer.builder().build();

        // when
        boolean guessTrue = cunsumer.checkCustomerStatus();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_success() {
        // given
        Customer cunsumer = NormalCustomer.builder().point(1L).build();

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Customer cunsumer = NormalCustomer.builder().point(0L).build();

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertFalse(guessTrue);
    }

}