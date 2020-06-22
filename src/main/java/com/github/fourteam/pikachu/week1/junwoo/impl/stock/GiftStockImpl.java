package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.gift.Gift;
import com.github.fourteam.pikachu.week1.junwoo.interfaces.stock.Stock;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:40 오전
 */
public class GiftStockImpl implements Stock {

    private final Gift gift;

    public GiftStockImpl(Gift gift) {
        this.gift = gift;
    }

    @Override
    public boolean checkStock(Integer Id) {
        return false;
    }
}
