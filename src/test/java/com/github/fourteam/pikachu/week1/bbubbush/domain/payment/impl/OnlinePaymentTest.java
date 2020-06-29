package com.github.fourteam.pikachu.week1.bbubbush.domain.payment.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl.NormalCustomer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl.ShopEmployee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl.SupplierEmployee;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.impl.OnlineOrderSheet;
import com.github.fourteam.pikachu.week1.bbubbush.domain.payment.Payment;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.impl.SalesProduct;
import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class OnlinePaymentTest {
    @Test
    public void payment_nomal_customer() {
        // given
        Cunsumer cunsumer = new NormalCustomer(2000L);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 200L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);
        Map<String, String> paymentResult = null;

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            paymentResult = payment.payment(orderSheet);
        }

        // then
        assertNotNull(paymentResult);
        assertFalse(paymentResult.containsKey("errCode"));
    }

    @Test
    public void payment_shop_employee() {
        // given
        Cunsumer cunsumer = new ShopEmployee(100000L, null);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 200L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);
        Map<String, String> paymentResult = null;

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            paymentResult = payment.payment(orderSheet);
        }

        // then
        assertNotNull(paymentResult);
        assertFalse(paymentResult.containsKey("errCode"));
    }

    @Test
    public void payment_supplier_employee() {
        // given
        Cunsumer cunsumer = new SupplierEmployee(2000L, null);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 200L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);
        Map<String, String> paymentResult = null;

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            paymentResult = payment.payment(orderSheet);
        }

        // then
        assertNotNull(paymentResult);
        assertFalse(paymentResult.containsKey("errCode"));
    }

    @Test
    public void payment_fail() {
        // given
        Cunsumer cunsumer = new SupplierEmployee(4300L, null);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 100L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);
        Map<String, String> paymentResult = null;

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            paymentResult = payment.payment(orderSheet);
        }

        // then
        assertNotNull(paymentResult);
        assertThat(paymentResult.get("errCode"), CoreMatchers.is(CoreMatchers.equalTo("401")));
    }

    @Test
    public void cancle_nomal_customer() {
        // given
        Cunsumer cunsumer = new NormalCustomer(2000L);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 200L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            payment.payment(orderSheet);
        }
        Map<String, String> cancleMap = payment.cancleOrder(orderSheet);

        // then
        assertNotNull(cancleMap);
        assertFalse(cancleMap.containsKey("errCode"));
    }

    @Test
    public void not_cancle_nomal_customer() {
        // given
        Cunsumer cunsumer = new NormalCustomer(2000L);
        List<Product> products = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            products.add(new SalesProduct(i, i * 10L, i * 200L, null));
        }

        Order orderSheet = new OnlineOrderSheet();
        Payment payment = new OnlinePayment();
        payment.setPaymentType(PaymentType.Kakaopay);

        // when
        if ( orderSheet.validationBeforeOrder(cunsumer, products) ) {
            payment.payment(orderSheet);
        }
        payment.setPaymentDate(LocalDate.now().minusDays(8));   // for test
        Map<String, String> cancleMap = payment.cancleOrder(orderSheet);

        // then
        assertNotNull(cancleMap);
        assertTrue(cancleMap.containsKey("errCode"));
    }


}