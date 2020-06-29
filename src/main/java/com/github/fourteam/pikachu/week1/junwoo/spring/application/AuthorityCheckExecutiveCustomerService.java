package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.AuthorityCheckRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:23 오후
 */
@Service
public class AuthorityCheckExecutiveCustomerService {

    AuthorityCheckRepository authorityCheckRepository;

    public AuthorityCheckExecutiveCustomerService(@Qualifier("autorityCheckExecutiveCustomerRepositoryImpl") final AuthorityCheckRepository authorityCheckRepository) {
        this.authorityCheckRepository = authorityCheckRepository;
    }

    public boolean authorityCheck(Customer customer) {
        return authorityCheckRepository.checkRole(customer);
    }

}
