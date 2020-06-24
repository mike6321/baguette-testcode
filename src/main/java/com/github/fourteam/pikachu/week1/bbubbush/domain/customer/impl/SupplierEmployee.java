package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;

import java.util.List;

public class SupplierEmployee implements Employee {
    private Long point;
    private List<Product> supplyProducts;

    @Builder
    public SupplierEmployee(Long point, List<Product> supplyProducts) {
        this.point = point;
        this.supplyProducts = supplyProducts;
    }

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *  공급사는 상품이 3개 이상 존재해야 주문 가능
     */
    @Override
    public boolean checkCustomerStatus() {
        return supplyProducts.size() >= 3;
    }

    /**
     * Name: 포인트 조회
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
        return product.getGiftProduct().getStock() >= 10L;
    }
}
