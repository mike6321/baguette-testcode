package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SalesGiftTest {
    @Test
    public void getStock_success() {
        // given
        GiftProduct giftProduct = SalesGift.builder()
                .code(20L)
                .stock(9L)
                .build();
        long expected = 9L;

        // when
        long stock = giftProduct.getStock();

        // then
        assertThat(stock, is(equalTo(expected)));
    }

    @Test
    public void getCode_success() {
        // given
        GiftProduct giftProduct = SalesGift.builder()
                .code(20L)
                .stock(9L)
                .build();
        long expected = 20L;

        // when
        long code = giftProduct.getCode();

        // then
        assertThat(code, is(equalTo(expected)));
    }

}