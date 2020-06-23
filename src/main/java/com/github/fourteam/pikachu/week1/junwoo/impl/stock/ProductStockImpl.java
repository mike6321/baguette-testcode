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

    // TODO:  junwoochoi 2020/06/23 12:41 오전
    // 리턴값은 재고가 있는 경우에는 true, 없는 경우에는 false로 한다.
    @Override
    public boolean checkStock() {
        return product.getPrdStk() != 0;
    }

}
