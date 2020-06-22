package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PaymentTest {
    private Customer[] customers;
    private Product[] products;
    private OrderSheet[] orderSheets;

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

        // 주문서 정보
        this.orderSheets = new OrderSheet[12];
        final ArrayList<OrderSheet> tempOrderSheetList = new ArrayList<>();
        for (Product product : this.products) {
            for (Customer customer : this.customers) {
                tempOrderSheetList.add(new OrderSheet.Builder(product, customer).build());
            }
        }
        this.orderSheets = tempOrderSheetList.toArray(new OrderSheet[tempOrderSheetList.size()]);
        System.out.println(this.orderSheets);
    }

    @Test
    public void 결제하기() {
        final Stream<OrderSheet> streamCanOrder = Arrays.stream(this.orderSheets).filter((orderSheet) -> {
            return "S".equals(orderSheet.orderSheetRequest().get("Status"));
        });

        final List<OrderSheet> canOrder = streamCanOrder.collect(Collectors.toList());
        for (OrderSheet orderSheet : canOrder) {
            new Payment(orderSheet).pay();
        }

    }

    
    @Test
    public void 결제실패() {
        
        final Stream<OrderSheet> streamCanNotOrder = Arrays.stream(this.orderSheets).filter((orderSheet) -> {
            return "E".equals(orderSheet.orderSheetRequest().get("Status"));
        });

        streamCanNotOrder.forEach(orderSheet -> {
            System.out.println(orderSheet.orderSheetRequest().get("Message"));
        });
    }
}