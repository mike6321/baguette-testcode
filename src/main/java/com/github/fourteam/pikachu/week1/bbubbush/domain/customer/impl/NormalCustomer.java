package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

public class NormalCustomer implements Customer {
    @Getter
    private Long point;

    @Builder
    public NormalCustomer(Long point) {
        this.point = point;
    }

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *     일반 고객은 주문가능
     */
    @Override
    public boolean checkCustomerStatus() {
        return true;
    }

    /**
     * Name: 포인트 확인
     * Date: 2020/06/22
     * Info:
     *
     */
    @Override
    public boolean chkPoint() {
        return point > 0L;
    }

    @Override
    public boolean checkGift(Product product) {
        return product.getGiftProduct().getStock() > 0L;
    }

    @Override
    public void usePoint(Long spendPoint) {
        point = point - spendPoint;
    }
}
