package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BlackCustomer implements Customer {
    private Long point;
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

    @Builder
    public BlackCustomer () {

    }

}
