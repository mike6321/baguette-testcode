package com.github.fourteam.pikachu.week1.bbubbush.domain.payment.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.domain.payment.Payment;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlinePayment implements Payment {
    private long paymentId;
    private PaymentType paymentType;

    @Override
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    @Override
    public Map<String, String> payment(Order ordersheet) {
        paymentId = createPaymentId();
        Cunsumer cunsumer = ordersheet.getCunsumer();
        List<Product> products = ordersheet.getProducts();
        long totalPaymentPrice = ordersheet.getTotalPaymentPrice();
        Map<String, String> outputMap = new HashMap();

        // 포인트가 존재할시 포인트로 선결제하고 나머지금액은 다른 결제수단으로 결제를 한다. 나머지금액이 1000원이하일경우는 불가
        if ( cunsumer.chkPoint() ) {
            totalPaymentPrice = usePoint(cunsumer, totalPaymentPrice);
        }

        if ( totalPaymentPrice > 0L && totalPaymentPrice <= 1000L ) {
            outputMap.put("errCode", "401");
            outputMap.put("errMsg", "포인트 차감 후 결제할 금액 " + totalPaymentPrice + "원이 1000원 이하 이므로 선택하신 결제수단으로 결제할 수 없습니다.");
            return outputMap;
        }

        if ( totalPaymentPrice > 0L ) {
            totalPaymentPrice = paymentByPaymentType(paymentType, totalPaymentPrice);
        }

        return outputMap;
    }

    /**
     * Name: 기본키 생성
     * Date: 2020/06/29
     * Info:
     *
     */
    private long createPaymentId() {
        return System.nanoTime();
    }

    /**
     * Name: 고객이 사용한 포인트 차감
     * Date: 2020/06/29
     * Info:
     *  차감한 만큼 총결제금액도 차감
     */
    private long usePoint(Cunsumer cunsumer, long totalPaymentPrice) {
        if ( cunsumer.getPoint() > totalPaymentPrice ) {
            System.out.println("포인트 " + totalPaymentPrice + "원을 사용하였습니다. 남은 포인트는 " + (cunsumer.getPoint() - totalPaymentPrice) + "원 입니다.");
            totalPaymentPrice = 0L;
            cunsumer.usePoint(totalPaymentPrice);
        }
        else {
            System.out.println("포인트 " + cunsumer.getPoint() + "원을 사용하였습니다. 남은 포인트는 0원 입니다.");
            totalPaymentPrice = totalPaymentPrice - cunsumer.getPoint();
            cunsumer.usePoint(cunsumer.getPoint());
        }

        return totalPaymentPrice;
    }

    /**
     * Name: 선택한 결제수단으로 잔액 결제
     * Date: 2020/06/29
     * Info:
     *  잔액을 결제하고 0원으로 만든다.
     */
    private long paymentByPaymentType(PaymentType paymentType, long totalPaymentPrice) {
        for (PaymentType value : PaymentType.values()) {
            if ( paymentType.equals(value) ) {
                System.out.println(paymentType.getPaymentName() + "를(을) " + totalPaymentPrice + "원 을 결제하였습니다.");
                totalPaymentPrice = 0L;
                break;

            }
        }
        return totalPaymentPrice;
    }

//    @Override
//    public boolean checkCancleOrder(Order ordersheet) {
//        return false;
//    }
//
//    @Override
//    public Map<String, String> cancleOrder(Order ordersheet) {
//        return null;
//    }


}
