package com.github.fourteam.pikachu.week1.bbubbush.domain.product;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesGift;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

public class SalesGiftTest {
    private GiftProduct giftProduct;

    @Before
    public void setUp() {
        giftProduct = SalesGift.builder().code(20L).stock(9).build();
    }

    @Test
    public void 사은품_재고확인() {
        long stock = giftProduct.getStock();

        assertEquals(stock, 9);
    }

}