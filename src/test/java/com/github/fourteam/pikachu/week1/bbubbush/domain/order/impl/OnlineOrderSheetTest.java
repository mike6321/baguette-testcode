package com.github.fourteam.pikachu.week1.bbubbush.domain.order.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl.NormalCustomer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.OnlineOrderSheet;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OnlineOrderSheetTest {

    @Test
    public void validationBeforeOrder_success() {
        // given
        List<Product> products = new ArrayList<>();
        products.add(new SalesProduct(1L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(2L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(3L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(4L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(5L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(6L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(7L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(8L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(9L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(10L, 10L, 100L, mock(GiftProduct.class)));
        Cunsumer cunsumer = new NormalCustomer(1000L);
        Order order = new OnlineOrderSheet();

        // when
        boolean guessTrue = order.validationBeforeOrder(cunsumer, products);

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void validationBeforeOrder_fail() {
        // given
        List<Product> products = new ArrayList<>();
        products.add(new SalesProduct(1L, 10L, 1100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(2L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(3L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(4L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(5L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(6L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(7L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(8L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(9L, 10L, 100L, mock(GiftProduct.class)));
        products.add(new SalesProduct(10L, 10L, 100L, mock(GiftProduct.class)));
        Cunsumer cunsumer = new NormalCustomer(1000L);
        Order order = new OnlineOrderSheet();

        // when
        boolean guessFalse = order.validationBeforeOrder(cunsumer, products);

        // then
        assertFalse(guessFalse);
    }
}