package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;

public class BlackCustomer implements Customer {
    final private Long point;

    public BlackCustomer (Long point) {
        this.point = point;
    }

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *   블랙컨슈머는 주문 불가
     */
    @Override
    public boolean checkCustomerStatus() {
        return false;
    }

    /**
     * Name: 회원의 포인트 존재여부 추가
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
        return false;
    }


}
