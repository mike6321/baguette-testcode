package com.github.fourteam.sample;

import java.util.List;

/**
 * Name: 학습 테스트를 위한 객체 생성
 * Date: 2020/06/13
 * Info:
 *
 */
public class OnlineShop {
    private List<String> product;

    public void setProducs(List<String> product) {
        this.product = product;
    }

    public boolean canThisShopOpen() {
        return product.size() >= 10;
    }
}
