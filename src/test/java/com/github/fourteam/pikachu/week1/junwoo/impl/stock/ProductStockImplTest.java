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
class ProductStockImplTest {

    private ProductStockImpl productStock;
    private Product product;

    @Before
    public void setUp() {
        product = new Product(1234l,1234l);
    }


}