package com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;

public class NullProduct implements Product {

    @Override
    public boolean checkProduct() {
        return false;
    }

    @Override
    public long getCode() {
        return 0;
    }

    @Override
    public long getPrice() {
        return 0;
    }

    @Override
    public GiftProduct getGiftProduct() {
        return null;
    }

    @Override
    public long getStock() {
        return 0;
    }
}
