package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.NullProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SupplierEmployeeTest {
    private Employee canOrderEmployee;
    private Employee canNotOrderEmployee;
    @Mock
    private List<Product> mockProducts;
    @InjectMocks
    private SupplierEmployee mockSupplierEmployee;

    @Before
    public void setUp() {
        LinkedList<Product> products = new LinkedList<>();
        products.add(new NullProduct());
        products.add(new NullProduct());
        products.add(new NullProduct());

        canOrderEmployee = SupplierEmployee.builder().supplyProducts(products).build();
        canNotOrderEmployee = SupplierEmployee.builder().supplyProducts(new LinkedList<Product>()).build();
    }

    @Test
    public void 주문가능상태_확인() {
        boolean guessPass = canOrderEmployee.checkCustomerStatus();
        boolean guessFail = canNotOrderEmployee.checkCustomerStatus();

        assertTrue(guessPass);
        assertFalse(guessFail);
    }

    @Test
    public void mock객체_테스트() {
        when(mockProducts.size()).thenReturn(2);

//        when(mockSupplierEmployee.checkCustomerStatus()).thenReturn(Boolean.FALSE);
        assertFalse(mockSupplierEmployee.checkCustomerStatus());
    }

}