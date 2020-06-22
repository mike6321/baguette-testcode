package com.github.fourteam.pikachu.week1.junwoo.impl.authority;

import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.interfaces.authority.AuthorityCheck;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:17 오후
 */
public class ExecutivesCustomerAuthorityCheckImpl implements AuthorityCheck {
    @Override
    public boolean checkRole(Customer customer) {

        return customer.getPoint() != 0;
    }
}
