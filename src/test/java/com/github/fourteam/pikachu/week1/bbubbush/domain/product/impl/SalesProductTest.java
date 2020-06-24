package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesGift;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SalesProductTest {
    @Test
    public void getGiftProductStock() {
        // given
        long expected = 10L;
        SalesGift salesGift = mock(SalesGift.class);
        Product product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .giftProduct(salesGift)    // mock 주입
                .stock(10L).build();
        when(salesGift.getStock()).thenReturn(10L);

        // when
        long giftProductStock = product.getGiftProduct().getStock();

        // then
        assertThat(giftProductStock, is(expected));
    }

    @Test
    public void getProductCode() {
        // given
        long expected = 99L;
        Product product = SalesProduct.builder()
                .code(99L)
                .price(10000L)
                .giftProduct(mock(SalesGift.class))    // mock 주입
                .stock(10L).build();

        // when
        long productCode = product.getCode();

        // then
        assertThat(productCode, is(expected));
    }

    @Test
    public void getProductPrice() {
        // given
        long expected = 10000L;
        Product product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .giftProduct(mock(SalesGift.class))    // mock 주입
                .stock(10L).build();

        // when
        long productPrice = product.getPrice();

        // then
        assertThat(productPrice, is(expected));
    }

    @Test
    public void getProductStco() {
        // given
        long expected = 16;
        Product product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .giftProduct(mock(SalesGift.class))    // mock 주입
                .stock(16L).build();

        // when
        long productStock = product.getStock();

        // then
        assertThat(productStock, is(expected));
    }

    @Test
    public void checkProduct_success() {
        // given
        Product product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .giftProduct(mock(SalesGift.class))    // mock 주입
                .stock(1L).build();

        // when
        boolean guessTrue = product.checkProduct();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void checkProduct_Fail() {
        // given
        Product product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .giftProduct(mock(SalesGift.class))    // mock 주입
                .stock(0L).build();

        // when
        boolean guessFalse = product.checkProduct();

        // then
        assertFalse(guessFalse);
    }

}