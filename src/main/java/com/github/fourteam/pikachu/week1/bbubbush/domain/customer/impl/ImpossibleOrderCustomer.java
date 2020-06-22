package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;
import lombok.Builder;

/**
 * Name: 거래거절 고객
 * Date: 2020/06/12
 * Info:
 *
 */
public class ImpossibleOrderCustomer implements Customer {

    @Builder
    public ImpossibleOrderCustomer(){

    }

    @Override
    public boolean checkCustomerStatus() {
        return false;
    }
}
