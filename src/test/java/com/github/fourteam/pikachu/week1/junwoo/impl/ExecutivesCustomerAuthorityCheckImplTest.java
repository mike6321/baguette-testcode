package com.github.fourteam.pikachu.week1.junwoo.impl;


import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:34 오후
 */
public class ExecutivesCustomerAuthorityCheckImplTest {

    @Test
    public void authorityCheck() {

        Customer customer0 = Customer.builder()
                                    .role(Role.GENERAL)
                                    .userId("mike6321")
                                    .point(30)
                                    .build();

        Customer customer1 = Customer.builder()
                                     .role(Role.GENERAL)
                                     .userId("mesung")
                                     .point(0)
                                     .build();

        List<Customer> customers = Arrays.asList(customer0, customer1);

        for (Customer customer : customers) {
            assertNotNull(customer);
            assertTrue(customer.getUserId()+" 님 포인트가 0이므로 주문서에 접근할 수 없습니다.", customer.getPoint() != 0);
            /*
            * cusstomer.sendMessage(객체);
            * Authority.check();
            *
            * */
        }



    }

}