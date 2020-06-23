package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.gift.Gift;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:47 오전
 */
public class GiftStockImplTest {

    private GiftStockImpl giftStock;
    private Gift gift;


    @Before
    public void setUp() {
        gift = new Gift(12345L,5);
    }

    @Test
    public void checkGiftStck() {
        GiftStockImpl mock = mock(GiftStockImpl.class);


    }
}