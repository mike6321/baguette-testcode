package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.stereotype.Component;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:19 오후
 */
@Component
public class AutorityCheckExecutiveCustomerRepositoryImpl implements AuthorityCheckRepository{
    @Override
    public boolean checkRole(Customer customer) {
        return customer.getPoint() != 0;
    }
}
