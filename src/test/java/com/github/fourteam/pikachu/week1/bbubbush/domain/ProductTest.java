package com.github.fourteam.pikachu.week1.bbubbush.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductTest {
    private Product[] products;

    @Before
    public void setUp() {
        products = new Product[3];

        products[0] = new Product.Builder()
                .productCode(111111L)
                .productPrice(20000L)
                .stock(10)
                .build();
        products[1] = new Product.Builder()
                .productCode(222222L)
                .productPrice(10000L)
                .stock(40)
                .build();
        products[2] = new Product.Builder()
                .productCode(333333L)
                .productPrice(10000L)
                .stock(0)
                .build();
    }

    @Test
    public void 기본객체_생성() {
        // given
        Product product = new Product.Builder()
                .productCode(10L)
                .productPrice(120000L)
                .gift(new GiftProduct.Builder(100L, 10).build())
                .stock(100)
                .build();

        // when - 아직은 별도의 서비스 코드가 없음

        // then
        assertThat(product, is(notNullValue()));
        assertThat(product.getPrdCd(), is(equalTo(10L)));
        assertThat(product.getPrdPrc(), is(equalTo(120000L)));
        assertThat(product.getGift().getGiftCd(), is(equalTo(100L)));
        assertThat(product.getStock(), is(equalTo(100)));
    }

    @Test
    public void 상품제고확인() {
        // given
        boolean[] canOrderStatus = new boolean[this.products.length];

        // when
        for (int i = 0; i < products.length; i++) {
            canOrderStatus[i] = products[i].checkHasStock();
        }

        // then
        assertTrue(canOrderStatus[0]);
        assertTrue(canOrderStatus[1]);
        assertFalse(canOrderStatus[2]);
    }

    @Test
    public void 상품제고확인_컬렉션() {
        // given

        // when
        List<Product> checkStatus = Arrays.stream(this.products).filter(Product::checkHasStock).collect(Collectors.toList());

        // thent
        assertThat(checkStatus.size(), is(equalTo(2)));
        assertThat(checkStatus.get(0).getPrdCd(), is(equalTo(111111L)));
        assertThat(checkStatus.get(1).getPrdPrc(), is(equalTo(10000L)));
    }
}