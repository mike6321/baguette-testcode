package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackCustomerTest {
    private Cunsumer cunsumer;
    @Before
    public void setUp() {
        cunsumer = BlackCustomer.builder().build();
    }

    @Test
    public void 권한체크하기() {
        boolean isPass = cunsumer.checkCustomerStatus();

        assertFalse(isPass);
    }

}