package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
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

    @Test
    public void checkGift_fail() {
        // given
        Cunsumer cunsumer = new ImpossibleOrderCustomer(0L);
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
    public void usePoint_fail() {
        // given
        Cunsumer cunsumer = new ImpossibleOrderCustomer(1000L);

        // when
        cunsumer.setPoint(100L);

        // then
        assertThat(cunsumer.getPoint(), is(equalTo(1000L)));
    }

}