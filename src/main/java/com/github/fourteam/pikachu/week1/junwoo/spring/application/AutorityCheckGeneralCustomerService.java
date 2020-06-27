package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.AuthorityCheckRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.domain.CustomerRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:23 오후
 */
@Service
public class AutorityCheckGeneralCustomerService {

    @Autowired
    AuthorityCheckRepository authorityCheckRepository;

    @Autowired
    CustomerRepository customerRepository;

    public AutorityCheckGeneralCustomerService(AuthorityCheckRepository authorityCheckRepository, CustomerRepository customerRepository) {
        this.authorityCheckRepository = authorityCheckRepository;
        this.customerRepository = customerRepository;
    }

    public boolean authorityCheck(String id) {

        return authorityCheckRepository.checkRole(customerRepository.findById(id));
    }

}
