package com.github.fourteam.pikachu.week1.bbubbush.domain.payment.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.domain.payment.Payment;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlinePayment implements Payment {
    private long paymentId;
    private long usePoint;
    private long usePaymentCredit;
    private long totalPaymentPrice;
    private PaymentType paymentType;
    private LocalDate paymentDate;

    @Override
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    @Override
    public Map<String, String> payment(Order ordersheet) {
        paymentId = createPaymentId();
        paymentDate = LocalDate.now();
        Cunsumer cunsumer = ordersheet.getCunsumer();
        List<Product> products = ordersheet.getProducts();
        totalPaymentPrice = ordersheet.getTotalPaymentPrice();
        Map<String, String> outputMap = new HashMap<>();

        // 포인트가 존재할시 포인트로 선결제하고 나머지금액은 다른 결제수단으로 결제를 한다. 나머지금액이 1000원이하일경우는 불가
        if ( cunsumer.chkPoint() ) {
            totalPaymentPrice = usePoint(cunsumer);
        }

        if ( totalPaymentPrice > 0L && totalPaymentPrice <= 1000L ) {
            cunsumer.setPoint(usePoint);
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
    private long usePoint(Cunsumer cunsumer) {
        if ( cunsumer.getPoint() > totalPaymentPrice ) {
            System.out.println("포인트 " + totalPaymentPrice + "원을 사용하였습니다. 남은 포인트는 " + (cunsumer.getPoint() - totalPaymentPrice) + "원 입니다.");
            usePoint = totalPaymentPrice;
            totalPaymentPrice = 0L;
            cunsumer.setPoint(totalPaymentPrice);
        }
        else {
            System.out.println("포인트 " + cunsumer.getPoint() + "원을 사용하였습니다. 남은 포인트는 0원 입니다.");
            usePoint = cunsumer.getPoint();
            totalPaymentPrice = totalPaymentPrice - cunsumer.getPoint();
            cunsumer.setPoint(cunsumer.getPoint());
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
                usePaymentCredit = totalPaymentPrice;
                totalPaymentPrice = 0L;
                break;

            }
        }
        return totalPaymentPrice;
    }

    private boolean checkCancleOrder() {
        if ( LocalDate.now().minusDays(7L).compareTo(paymentDate) > 0 ) {
            System.out.println("주문일 : " + paymentDate.toString() + ", 주문일로부터 7일 이내 주문취소가 가능합니다.");
            return false;
        }
        return true;
    }

    @Override
    public Map<String, String> cancleOrder(Order ordersheet) {
        Map<String, String> outputMap = new HashMap<>();
        if ( !checkCancleOrder() ) {
            outputMap.put("errCode", "501");
            outputMap.put("errMsg", "주문일로부터 7일이 지나 취소가 불가능합니다.");
            return outputMap;
        }

        ordersheet.getCunsumer().setPoint(this.usePoint);
        canclePayment();

        return outputMap;
    }

    @Override
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    private void canclePayment() {
        System.out.println("결제취소 :: " + paymentType.getPaymentName() + "으로 결제한 " + usePaymentCredit + "원 을 취소하였습니다.");
    }
}
