package com.github.fourteam.pikachu.week1.junwoo.spring.domain;


import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:19 오후
 */
@Component
@Qualifier("autorityCheckGeneralCustomerRepositoryImpl")
public class AutorityCheckGeneralCustomerRepositoryImpl implements AuthorityCheckRepository {

    @Override
    public boolean checkRole(Customer customer) {
        return customer.getRole() != Role.BLACKCONSUMER;
    }
}
