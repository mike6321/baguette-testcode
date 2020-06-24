package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void checkGift_fail() {
        // given
        Cunsumer cunsumer = new ShopEmployee(0L, null);
        Product product = SalesProduct.builder()
                .code(1L)
                .stock(100L)
                .price(20000)
                .giftProduct(Mockito.mock(GiftProduct.class))
                .build();

        // when
        boolean guessFalse = cunsumer.checkGift(product);

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void checkGift_success() {
        // given
        Cunsumer cunsumer = new ShopEmployee(0L, null);
        Product product = SalesProduct.builder()
                .code(1L)
                .stock(100L)
                .price(20000)
                .giftProduct(null)
                .build();

        // when
        boolean guessTrue = cunsumer.checkGift(product);

        // then
        assertTrue(guessTrue);
    }
}