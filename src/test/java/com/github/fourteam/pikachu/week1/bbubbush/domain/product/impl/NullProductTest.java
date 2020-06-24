package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


class NullProductTest {
    @Test
    void checkProduct() {
        // given
        Product product = new NullProduct();

        // when
        boolean guessFalse = product.checkProduct();

        // then
        assertFalse(guessFalse);
    }

    @Test
    void getCode() {
        // given
        Product product = new NullProduct();

        // when
        long productCode = product.getCode();

        // then
        Assert.assertThat(productCode, is(equalTo(0L)));
    }

    @Test
    void getPrice() {
        // given
        Product product = new NullProduct();

        // when
        long productPrice = product.getPrice();

        // then
        assertThat(productPrice, is(equalTo(0L)));
    }

    @Test
    void getGiftProduct() {
        // given
        Product product = new NullProduct();

        // when
        GiftProduct giftProduct = product.getGiftProduct();

        // then
        assertNull(giftProduct);
    }

    @Test
    void getStock() {
        // given
        Product product = new NullProduct();

        // when
        long productStock = product.getStock();

        // then
        assertThat(productStock, is(equalTo(0L)));
    }
}