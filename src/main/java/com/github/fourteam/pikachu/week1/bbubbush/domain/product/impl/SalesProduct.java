package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SalesProduct implements Product {
    private long code;
    private long stock;
    private long price;
    private GiftProduct gift;

    @Override
    public long getCode() {
        return this.code;
    }

    @Override
    public GiftProduct getGiftProduct() {
        return gift;
    }

    @Builder
    public SalesProduct(long code, long stock, long price, GiftProduct gift) {
        this.code = code;
        this.stock = stock;
        this.price = price;
        this.gift = gift;
    }

    /**
     * Name: 상품 주문가능여부 확인
     * Date: 2020/06/15
     * Info:
     *  재고가 있으면 true, 없으면 false
     */
    @Override
    public boolean checkProduct() {
        return stock > 0;
    }

}
