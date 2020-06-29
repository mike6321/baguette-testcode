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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

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
        assertThat(paymentResult.get("errCode"), CoreMatchers.is(CoreMatchers.equalTo("401")));
    }

}