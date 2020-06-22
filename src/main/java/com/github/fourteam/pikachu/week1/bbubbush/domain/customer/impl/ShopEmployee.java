package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class ShopEmployee implements Employee {
    private Long point;
    private LocalDate retireDate;

    @Builder
    public ShopEmployee(Long point, LocalDate retireDate) {
        this.point = point;
        this.retireDate = retireDate;
    }

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *  임직원은 포인트가 0보다 크고, 퇴사일자가 없는 경우 주문가능
     */
    @Override
    public boolean checkCustomerStatus() {
        return point > 0L && retireDate == null;
    }
}
