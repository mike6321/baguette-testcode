package com.github.fourteam.pikachu.week1.bbubbush.type;

public enum PaymentType {
    Kakaopay("카카오페이")
    , Cash("현금")
    , CreditCard("신용카드")
    , Point("포인트")
    ;

    private String paymentName;
    PaymentType(String name) {
        this.paymentName = name;
    }

    /**
     * Name: 결제수단의 이름을 전달
     * Date: 2020/05/29
     * Info:
     *  각 결제수단 별 한글 이름 전달
     */
    public String getPaymentName() {
        return paymentName;
    }
}
