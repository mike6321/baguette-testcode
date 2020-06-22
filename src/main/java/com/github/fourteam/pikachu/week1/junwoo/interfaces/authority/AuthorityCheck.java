package com.github.fourteam.pikachu.week1.junwoo.interfaces.authority;

import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:16 오후
 */
public interface AuthorityCheck {
    boolean checkRole(Customer customer);
}
