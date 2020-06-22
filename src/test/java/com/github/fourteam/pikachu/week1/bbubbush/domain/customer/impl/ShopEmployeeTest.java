package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ShopEmployeeTest {
    private Employee canOrderEmployee;
    private Employee canNotOrderEmployee;

    @Before
    public void setUp() {
        canOrderEmployee = ShopEmployee.builder().point(1000L).build();
        canNotOrderEmployee = ShopEmployee.builder().point(0L).build();
    }

    @Test
    public void 주문가능상태_확인() {
        boolean guessPass = canOrderEmployee.checkCustomerStatus();
        boolean guessFail = canNotOrderEmployee.checkCustomerStatus();

        assertTrue(guessPass);
        assertTrue(guessFail);
    }


}