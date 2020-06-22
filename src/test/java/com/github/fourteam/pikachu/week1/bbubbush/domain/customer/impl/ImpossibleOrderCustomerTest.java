package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImpossibleOrderCustomerTest {
    @Test
    public void checkCustomerStatus_fail() {
        // given
        Customer cunsumer = ImpossibleOrderCustomer.builder().build();

        // when
        boolean guessFalse = cunsumer.checkCustomerStatus();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void chkPoint_success() {
        // given
        Customer cunsumer = ImpossibleOrderCustomer.builder().point(1L).build();

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Customer cunsumer = ImpossibleOrderCustomer.builder().point(0L).build();

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertFalse(guessTrue);
    }

}