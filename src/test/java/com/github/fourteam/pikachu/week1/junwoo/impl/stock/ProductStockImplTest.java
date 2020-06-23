package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:10 오전
 */
public class ProductStockImplTest {

    private ProductStockImpl productStock;
    private Product product;

    @Test
    public void checkStock() {
        Product productMock = product.builder().prdId(1234L)
                .prdStk(20)
                .build();

        Product productMockNothing = product.builder().prdId(1234L)
                .prdStk(0)
                .build();


        productStock = new ProductStockImpl(productMock);
        boolean result = productStock.checkStock();
        assertTrue(result);


        productStock = new ProductStockImpl(productMockNothing);
        result = productStock.checkStock();
        assertTrue(result);


    }


}