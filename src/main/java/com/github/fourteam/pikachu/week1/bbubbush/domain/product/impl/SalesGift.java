package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SalesGift implements GiftProduct {
    private long code;
    private long stock;

    @Builder
    public SalesGift(long code, long stock) {
        this.code = code;
        this.stock = stock;
    }




}
