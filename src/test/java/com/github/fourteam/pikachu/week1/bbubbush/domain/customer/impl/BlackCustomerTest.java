package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        boolean guessFalse = cunsumer.chkPoint();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void checkGift_fail() {
        // given
        Cunsumer cunsumer = new BlackCustomer(0L);
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
}