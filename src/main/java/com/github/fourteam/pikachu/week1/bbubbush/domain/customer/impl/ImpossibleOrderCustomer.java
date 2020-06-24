package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

/**
 * Name: 거래거절 고객
 * Date: 2020/06/12
 * Info:
 *
 */
public class ImpossibleOrderCustomer implements Customer {
    @Getter
    private Long point;

    @Builder
    public ImpossibleOrderCustomer(Long point){
        this.point = point;
    }

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/22
     * Info:
     *  거래거절 고객은 주문 불가
     */
    @Override
    public boolean checkCustomerStatus() {
        return false;
    }

    /**
     * Name: 포인트 확인
     * Date: 2020/06/22
     * Info:
     *  인
     */
    @Override
    public boolean chkPoint() {
        return point > 0L;
    }

    @Override
    public boolean checkGift(Product product) {
        return false;
    }
}
