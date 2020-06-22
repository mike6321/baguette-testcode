package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Employee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SupplierEmployee implements Employee {
    private List<Product> supplyProducts;

    @Builder
    public SupplierEmployee(List<Product> supplyProducts) {
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
}
