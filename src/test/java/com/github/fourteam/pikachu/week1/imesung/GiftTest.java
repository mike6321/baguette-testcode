package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustType;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.ExecutivesCust;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Gift;
import com.github.fourteam.pikachu.week1.imesung.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GiftTest {

    @Before
    public void setUp() {
    }

    @Test
    public void 사은품_재고확인() {
        //given
        Customer customer = mock(Customer.class);
        Gift gift = GiftProduct.builder()
                .stock(4L)
                .build();

        //when
        when(customer.getCustType()).thenReturn(CustType.GENERAL);

        //then
        assertTrue(gift.checkGift());
    }

}