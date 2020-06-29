package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

public class ShopEmployee implements Employee {
    @Getter
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
        return product.getGiftProduct() == null;
    }

    @Override
    public void usePoint(Long spendPoint) {
        point = point - spendPoint;
    }

}
