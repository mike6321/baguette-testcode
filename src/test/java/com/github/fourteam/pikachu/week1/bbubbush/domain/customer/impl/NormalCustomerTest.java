package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void checkGift_fail() {
        // given
        Cunsumer cunsumer = new NormalCustomer(0L);
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
        Cunsumer cunsumer = new NormalCustomer(0L);
        Product product = SalesProduct.builder()
                .code(1L)
                .stock(100L)
                .price(20000)
                .giftProduct(Mockito.mock(GiftProduct.class))
                .build();
        Mockito.when(product.getGiftProduct().getStock()).thenReturn(1L);   // 사은품의 재고 mocking
        // when
        boolean guessTrue = cunsumer.checkGift(product);

        // then
        assertTrue(guessTrue);
    }
}