package com.github.fourteam.pikachu.week1.bbubbush.domain.product;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesGift;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SalesProductTest {
    @InjectMocks private Product product;
    @Mock private SalesGift salesGift;

    @Before
    public void setUp() {
        product = SalesProduct.builder()
                .code(10L)
                .price(10000L)
                .gift(salesGift)    // mock 주입
                .stock(10L).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void 주문가능상태_확인() {
        boolean guessTrue = product.checkProduct();
        when(salesGift.getStock()).thenReturn(10L);

        long giftProductStock = product.getGiftProduct().getStock();

        assertTrue(guessTrue);
        assertEquals(giftProductStock, 10L);
        verify(salesGift).getStock();
    }
}