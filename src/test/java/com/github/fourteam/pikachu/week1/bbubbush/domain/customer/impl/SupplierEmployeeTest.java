package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.NullProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SupplierEmployeeTest {
    @Test
    public void checkCustomerStatus_success() {
        // given
        List<Product> mockProducts = mock(List.class);
        Cunsumer customer = SupplierEmployee.builder()
                    .point(0L)
                    .supplyProducts(mockProducts)
                    .build();
        when(mockProducts.size()).thenReturn(10);

        // when
        boolean guessTrue = customer.checkCustomerStatus();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void checkCustomerStatus_fail() {
        // given
        List<Product> mockProducts = mock(List.class);
        Cunsumer customer = SupplierEmployee.builder()
                .point(0L)
                .supplyProducts(mockProducts)
                .build();
        when(mockProducts.size()).thenReturn(2);

        // when
        boolean guessFalse = customer.checkCustomerStatus();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void chkPoint_success() {
        // given
        Cunsumer customer = SupplierEmployee.builder().point(1L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Cunsumer customer = SupplierEmployee.builder().point(0L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertFalse(guessTrue);
    }

}