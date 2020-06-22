package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class OrderSheetTest {
    private Customer[] customers;
    private Product[] products;

    @Before
    public void setUp () {
        // 사은품
        final GiftProduct emptyGift = new GiftProduct.Builder(0L, 0).build();

        // 상품정보
        products = new Product[3];
        products[0] = new Product.Builder()
                .productCode(111111L)
                .productPrice(20000L)
                .gift(new GiftProduct.Builder(12345L, 3).build())
                .stock(10)
                .build();
        products[1] = new Product.Builder()
                .productCode(222222L)
                .productPrice(10000L)
                .gift(emptyGift)
                .stock(40)
                .build();
        products[2] = new Product.Builder()
                .productCode(333333L)
                .productPrice(10000L)
                .gift(emptyGift)
                .stock(0)
                .build();

        // 고객정보
        this.customers = new Customer[5];
        this.customers[0] = new Customer.Builder("dynee313", "dy", CustomerType.Employees)
                .hasPoint(0L)
                .isBlackConsumer(false)
                .builder();
        this.customers[1] = new Customer.Builder("imesung", "hs", CustomerType.Employees)
                .hasPoint(10000L)
                .isBlackConsumer(false)
                .builder();
        this.customers[2] = new Customer.Builder("mike6321", "jw", CustomerType.Normal)
                .hasPoint(2000L)
                .isBlackConsumer(false)
                .builder();
        this.customers[3] = new Customer.Builder("bbubbush", "sh", CustomerType.Normal)
                .hasPoint(0L)
                .isBlackConsumer(true)
                .builder();
        this.customers[4] = new Customer.Builder("wonrack", "wr", CustomerType.CanNotOrder)
                .hasPoint(3000L)
                .isBlackConsumer(false)
                .builder();

    }

    @Test(expected = RequiredValueException.class)
    public void Null_파라미터_체크() {
        final OrderSheet orderSheet = new OrderSheet.Builder(null, null).build();

        final Map<String, String> responseMap = orderSheet.orderSheetRequest();
    }

    @Test
    public void 주문서_진입가능여부_실패() {
        Product product = products[0];
        Customer customer = customers[0];
        final OrderSheet orderSheetFail = new OrderSheet.Builder(product, customer).build();

        Map<String, String> responseMap = orderSheetFail.orderSheetRequest();

        assertThat(responseMap.get("Status"), is(equalTo("E")));
    }

    @Test
    public void 주문서_진입가능여부_성공() {
        Product product = products[0];
        Customer customer = customers[2];
        final OrderSheet orderSheetSuccess = new OrderSheet.Builder(product, customer).build();

        Map<String, String> responseMap = orderSheetSuccess.orderSheetRequest();

        assertThat(responseMap.get("Status"), is(equalTo("S")));
    }

    @Test
    public void 거래거절고객_진입가능여부 () {
        final Product product = this.products[0];
        final Customer canNotOrder = this.customers[4];
        final OrderSheet orderSheet = new OrderSheet.Builder(product, canNotOrder).build();

        final Map<String, String> responseMap = orderSheet.orderSheetRequest();

        assertThat(responseMap.get("Status"), is(equalTo("E")));
        assertThat(responseMap.get("Message"), is(containsString("거래거절")));
    }
}