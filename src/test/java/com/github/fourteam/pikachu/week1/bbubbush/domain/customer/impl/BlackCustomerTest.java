package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackCustomerTest {
    @Test
    public void checkCustomerStatus_fail() {
        // given
        Cunsumer cunsumer = new BlackCustomer(0L);

        // when
        boolean guessFalse = cunsumer.checkCustomerStatus();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void chkPoint_success() {
        // given
        Cunsumer cunsumer = new BlackCustomer(1L);

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Cunsumer cunsumer = new BlackCustomer(0L);

        // when
        boolean guessTrue = cunsumer.chkPoint();

        // then
        assertFalse(guessTrue);
    }
}