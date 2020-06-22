package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;

public class Payment {
    private OrderSheet orderSheet;
    private PaymentType paymentType;   // 기본은 신용카드

    private long totalPayment;

    public Payment(OrderSheet orderSheet){
        this(orderSheet, PaymentType.CreditCard);
    }

    public Payment(OrderSheet orderSheet, PaymentType paymentType) {
        this.orderSheet = orderSheet;
        this.paymentType = paymentType;

        this.totalPayment = orderSheet.getProduct().getPrdPrc();
        this.totalPayment = orderSheet.getProduct().getPrdPrc();
    }

    /**
     * Name: 결제하기
     * Date: 2020/05/29
     * Info:
     *  고객이 포인트를 사용할 수 있으면, 먼저 사용하고 남은 금액을 결제수단을 통해 차감
     */
    public void pay() {
        if ( this.orderSheet.getCustomer().canUsePoint() ) {
            final long point = this.orderSheet.getCustomer().getPoint();
            if ( this.totalPaymentMoreThanPoint(point) ) {
                // 결제금액 >= 포인트
                this.orderSheet.getCustomer().usePoint(point);
                this.totalPayment -= point;
            }
            else {
                // 결제금액 < 포인트
                this.orderSheet.getCustomer().usePoint(point - this.totalPayment);
                this.totalPayment = 0;
            }
        }
        System.out.println(this.toString());
    }

    /**
     * Name: 전체 주문금액과 고객의 포인트를 비교
     * Date: 2020/05/29
     * Info:
     *  고객이 가진 포인트와 총 결제금액을 비교하여 총 결제금액이 포인트보다 크거나 같으면 true, 작으면 false 리턴
     */
    private boolean totalPaymentMoreThanPoint(long point) {
        return this.totalPayment >= point;
    }

    @Override
    public String toString() {
        return "[" +
                orderSheet.getCustomer().getUserName() + " 님이 구매하신 상품의 금액은 총 " + orderSheet.getProduct().getPrdPrc() + " 원 입니다. \n" +
                "사용하신 포인트는 " + (this.totalPayment == orderSheet.getProduct().getPrdPrc() ? "없으며, " : (orderSheet.getProduct().getPrdPrc() - orderSheet.getCustomer().getPoint())) + " 이며, 남은 포인트는 " + orderSheet.getCustomer().getPoint() + " 입니다.\n" +
                (this.totalPayment == 0 ? "구매해주셔서 감사합니다." : "남은 잔액 " + this.totalPayment + " 원은 " + this.paymentType.getPaymentName() + " 으로 결제했습니다.") +
                "]";
    }
}
