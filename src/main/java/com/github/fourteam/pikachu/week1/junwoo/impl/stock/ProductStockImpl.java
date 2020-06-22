package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.product.Product;
import com.github.fourteam.pikachu.week1.junwoo.interfaces.stock.Stock;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:40 오전
 */
public class ProductStockImpl implements Stock {

    private final Product product;

    public ProductStockImpl(Product product) {
        this.product = product;
    }

    @Override
    public boolean checkStock(Integer Id) {
        return false;
    }
}
