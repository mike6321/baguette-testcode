package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ShopEmployeeTest {
    @Test
    public void checkCustomerStatus_true() {
        // given
        Cunsumer customer = ShopEmployee.builder().point(1L).build();

        // when
        boolean guessTrue = customer.checkCustomerStatus();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void checkCustomerStatus_fail() {
        // given
        Cunsumer customer = ShopEmployee.builder()
                .point(1L)
                .retireDate(LocalDate.now())
                .build();

        // when
        boolean guessFalse = customer.checkCustomerStatus();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void chkPoint_success() {
        // given
        Cunsumer customer = ShopEmployee.builder().point(1L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Cunsumer customer = ShopEmployee.builder().point(0L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertFalse(guessTrue);
    }
}