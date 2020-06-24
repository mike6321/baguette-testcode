package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SupplierEmployeeTest {
    @Test
    public void checkCustomerStatus_success() {
        // given
        List<Product> mockProducts = mock(List.class);
        Cunsumer customer = SupplierEmployee.builder()
                    .point(0L)
                    .supplyProducts(mockProducts)
                    .build();
        when(mockProducts.size()).thenReturn(10);

        // when
        boolean guessTrue = customer.checkCustomerStatus();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void checkCustomerStatus_fail() {
        // given
        List<Product> mockProducts = mock(List.class);
        Cunsumer customer = SupplierEmployee.builder()
                .point(0L)
                .supplyProducts(mockProducts)
                .build();
        when(mockProducts.size()).thenReturn(2);

        // when
        boolean guessFalse = customer.checkCustomerStatus();

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void chkPoint_success() {
        // given
        Cunsumer customer = SupplierEmployee.builder().point(1L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertTrue(guessTrue);
    }

    @Test
    public void chkPoint_fail() {
        // given
        Cunsumer customer = SupplierEmployee.builder().point(0L).build();

        // when
        boolean guessTrue = customer.chkPoint();

        // then
        assertFalse(guessTrue);
    }
    @Test
    public void checkGift_fail() {
        // given
        Cunsumer cunsumer = new SupplierEmployee(0L, null);
        Product product = SalesProduct.builder()
                .code(1L)
                .stock(100L)
                .price(20000)
                .giftProduct(Mockito.mock(GiftProduct.class))
                .build();
        when(product.getGiftProduct().getStock()).thenReturn(9L);

        // when
        boolean guessFalse = cunsumer.checkGift(product);

        // then
        assertFalse(guessFalse);
    }

    @Test
    public void checkGift_success() {
        // given
        Cunsumer cunsumer = new SupplierEmployee(0L, null);
        Product product = SalesProduct.builder()
                .code(1L)
                .stock(100L)
                .price(20000)
                .giftProduct(Mockito.mock(GiftProduct.class))
                .build();
        when(product.getGiftProduct().getStock()).thenReturn(10L);

        // when
        boolean guessTrue = cunsumer.checkGift(product);

        // then
        assertTrue(guessTrue);
    }

}