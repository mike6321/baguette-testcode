package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.product.GeneralProduct;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ProductTest {
    List<Product> products = new ArrayList<>();

    @Before
    public void setUp() {
        products.add(GeneralProduct.builder()
                .prdCd(1111)
                .price(5000L)
                .build());

        products.add(GeneralProduct.builder()
                .prdCd(1112)
                .price(5000L)
                .build());

        products.add(GeneralProduct.builder()
                .prdCd(1113)
                .price(5000L)
                .build());

        products.add(GeneralProduct.builder()
                .prdCd(1114)
                .price(5000L)
                .build());

        products.add(GeneralProduct.builder()
                .prdCd(1114)
                .price(3000L)
                .build());
    }

    @Test
    public void 상품재고여부확인() {
        //given
        Product product = GeneralProduct.builder()
                .stock(3L)
                .supId("1001")
                .build();
        //when

        //then
        assertTrue(product.checkProduct());
    }

    @Test
    public void 구매가능상품목록() {
        //given
        /*Customer customer = Customer.builder()
                .point(4000L)
                .build();*/
        Customer customer = mock(Customer.class);

        //when
        when(customer.getPoint()).thenReturn(4000L);
        when(customer.chkPrdListInfo(products)).thenReturn(1);

        //then
        assertThat(customer.chkPrdListInfo(products), is(CoreMatchers.equalTo(1)));

    }
}