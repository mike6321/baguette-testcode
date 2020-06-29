package com.github.fourteam.pikachu.week1.bbubbush.domain.payment;

import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;

import java.time.LocalDate;
import java.util.Map;

public interface Payment {

    void setPaymentType(PaymentType paymentType);

    Map<String, String> payment(Order ordersheet);

    Map<String, String> cancleOrder(Order ordersheet);

    void setPaymentDate(LocalDate paymentDate);
}
