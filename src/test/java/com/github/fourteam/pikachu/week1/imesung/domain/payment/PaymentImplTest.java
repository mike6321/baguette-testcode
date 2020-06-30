package com.github.fourteam.pikachu.week1.imesung.domain.payment;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustType;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.product.GeneralProduct;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;

public class PaymentImplTest {

    @Test
    public void payWithPoint() {
        //given
        Customer customer = Customer.builder()
                .userId("mesung")
                .userName("이메성")
                .custType(CustType.GENERAL)
                .point(5000L)
                .blackConsumerFlg(false)
                .build();

        Product product = GeneralProduct.builder()
                .prdCd(1111)
                .price(10000L)
                .build();

        Payment payment = PaymentImpl.builder().build();

        //then

        //when
        assertTrue(payment.payment(customer, product));
    }

    @Test
    public void chkCancelOrder() throws ParseException {
        //given
        Payment payment = PaymentImpl.builder()
                .orderDtm("20200625")
                .build();

        //when
        assertTrue(payment.checkCancelOrder());
    }
}