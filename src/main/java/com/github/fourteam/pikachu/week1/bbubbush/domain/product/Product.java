package com.github.fourteam.pikachu.week1.bbubbush.domain.product;

public interface Product {
    boolean checkProduct();

    long getCode();

    long getPrice();

    GiftProduct getGiftProduct();

    long getStock();
}
