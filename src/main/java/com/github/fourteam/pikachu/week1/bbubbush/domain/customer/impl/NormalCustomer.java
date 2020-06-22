package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import lombok.Builder;

public class NormalCustomer implements Customer {
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
}
