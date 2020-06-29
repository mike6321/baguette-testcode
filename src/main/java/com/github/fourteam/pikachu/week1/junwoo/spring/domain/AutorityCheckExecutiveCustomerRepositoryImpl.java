package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Project : pikachu
 * 임직원의 경우 포인트가 0인 경우 주문 불가
 * @author : jwdeveloper
 * @comment :
 * Time : 8:19 오후
 */
@Component
@Qualifier("autorityCheckExecutiveCustomerRepositoryImpl")
public class AutorityCheckExecutiveCustomerRepositoryImpl implements AuthorityCheckRepository {

    @Override
    public boolean checkRole(Customer customer) {
        return customer.getPoint() != 0 && customer.getRole() == Role.EXECUTIVES;
    }
}
