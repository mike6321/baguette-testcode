package com.github.fourteam.pikachu.week1.bbubbush.domain;

import static org.hamcrest.CoreMatchers.*;

import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer[] customers;


    @Before
    public void setUp() {
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


    @Test
    public void 기본객체_생성하기() {
        // given
        Customer customer = new Customer.Builder("bbubbush", "이상훈", CustomerType.Employees)
                .hasPoint(1000L)
                .isBlackConsumer(false)
                .builder();

        // when

        // then
        assertThat(customer, is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("bbubbush")));
        assertThat(customer.getUserName(), is(equalTo("이상훈")));
        assertThat(customer.getUserType(), is(equalTo(CustomerType.Employees)));
        assertThat(customer.getUserType().getCustomerTypeValue(), is(equalTo(0)));
        assertThat(customer.getPoint(), is(equalTo(1000L)));
        assertFalse(customer.isBlackConsumerFlg());
    }


    @Test
    public void 주문가능상태_체크() {
        // given - setUp() 객체사용
        boolean[] canOrderStatus = new boolean[this.customers.length];

        // when

        for (int i = 0; i < this.customers.length; i++) {
            canOrderStatus[i] = this.customers[i].checkCustomerStatus();
        }


        // then
        assertFalse(canOrderStatus[0]);
        assertTrue(canOrderStatus[1]);
        assertTrue(canOrderStatus[2]);
        assertFalse(canOrderStatus[3]);


    }
    @Test
    public void 주문가능상태_체크_컬렉션버전 () {
        // given

        // when
        List<Customer> checkStatus = Arrays.stream(this.customers)
                .filter(Customer::checkCustomerStatus)
                .collect(Collectors.toList());
        // then
        assertThat(checkStatus.size(), is(equalTo(2)));
        assertThat(checkStatus.get(0).getUserName(), is(equalTo("hs")));
        assertThat(checkStatus.get(1).getUserName(), is(equalTo("jw")));

    }

    @Test
    public void 거래거절고객_주문가능상태_체크 () {
        // given
        final Customer canNotOrder = this.customers[4];
        // when
        final boolean hisCanOrder = canNotOrder.checkCustomerStatus();
        // then
        assertFalse(hisCanOrder);
    }
}