package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

import java.util.HashMap;
import java.util.Map;

public class OrderSheet {
    private final Product product;
    private final Customer customer;

    public static class Builder {
        private Product product;
        private Customer customer;

        public Builder(Product product, Customer customer) {
            this.product = product;
            this.customer = customer;
        }
        public OrderSheet build(){
            if ( this.product == null ) throw new RequiredValueException("상품정보를 확인해주세요.");
            if ( this.customer == null ) throw new RequiredValueException("고객정보를 확인해주세요.");
            return new OrderSheet(this);
        }
    }

    private OrderSheet(Builder builder) {
        this.product = builder.product;
        this.customer = builder.customer;
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Name: 결제 전, 주문 가능상태 확인
     * Date: 2020/05/29
     * Info:
     *  고객, 상품, 사은품의 상태를 확인.
     * KeyInfo:
     *      Status :: 주문가능상태 (S: 가능, E: 불가)
     *      Message :: 주문이 불가할 때, 원인을 담음
     */
    public Map<String, String> orderSheetRequest () {
        HashMap<String, String> outputMap = new HashMap<>();
        outputMap.put("Status", "E");

        // 고객 체크
        final boolean isCanOrderCustomer = this.customer.checkCustomerStatus();
        if ( !isCanOrderCustomer ) {
            if ( customer.getUserType().equals(CustomerType.Employees) ) {
                outputMap.put("Message", "포인트가 존재하지 않습니다.");
            }
            else if ( customer.getUserType().equals(CustomerType.Normal) ) {
                outputMap.put("Message", "블랙컨슈머는 주문할 수 없습니다.");
            }
            else if ( customer.getUserType().equals(CustomerType.CanNotOrder) ) {
                outputMap.put("Message", "거래거절 고객입니다.");
            }
            return outputMap;
        }

        // 상품 체크
        final boolean isCanOrderProduct = this.product.checkHasStock();
        if ( !isCanOrderProduct ) {
            outputMap.put("Message", "상품의 재고가 부족합니다.");
            return outputMap;
        }

        // 사은품 체크
        final boolean isCanOrderGiftProduct = this.product.getGift().checkHasStock();
        if ( !isCanOrderGiftProduct && this.customer.getUserType().equals(CustomerType.Normal)) {
            outputMap.put("Message", "사은품의 재고가 부족합니다.");
            return outputMap;
        }
        else if ( this.product.getGift().getGiftCd() != 0L  && this.customer.getUserType().equals(CustomerType.Employees) ) {
            outputMap.put("Message", "임직원은 사은품이 존재하는 상품을 주문할 수 없습니다.");
            return outputMap;
        }

        outputMap.put("Status", "S");
        outputMap.put("Message", "");
        return outputMap;
    }
}
