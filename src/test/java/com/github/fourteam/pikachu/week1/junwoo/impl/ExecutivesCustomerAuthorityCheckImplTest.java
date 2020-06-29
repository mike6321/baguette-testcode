package com.github.fourteam.pikachu.week1.junwoo.impl;


import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import com.github.fourteam.pikachu.week1.junwoo.impl.authority.ExecutivesCustomerAuthorityCheckImpl;
import com.github.fourteam.pikachu.week1.junwoo.interfaces.authority.AuthorityCheck;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:34 오후
 */
public class ExecutivesCustomerAuthorityCheckImplTest {

    @Test
    public void authorityCheckt() {
        Customer customer = Customer.builder()
                .userId("bbubbush")
                .point(0)
                .role(Role.BLACKCONSUMER)
                .build();

        assertNotNull(customer);
        assertFalse("블랙컨슈머 고객은 주문이 불가합니다...",customer.getRole() == Role.BLACKCONSUMER);

    }


    @Test
    public void 인증객체_사용() {
        // given
        Customer customer = Customer.builder()
                .userId("bbubbush")
                .point(0)
                .role(Role.BLACKCONSUMER)
                .build();
        AuthorityCheck authorityCheck = new ExecutivesCustomerAuthorityCheckImpl();

        // when
        final boolean canHeOrder = authorityCheck.checkRole(customer);

        // then
        assertFalse(canHeOrder);

    }

}