package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.stereotype.Repository;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:17 오후
 */
@Repository
public interface AuthorityCheckRepository {
    boolean checkRole(Customer customer);
}
