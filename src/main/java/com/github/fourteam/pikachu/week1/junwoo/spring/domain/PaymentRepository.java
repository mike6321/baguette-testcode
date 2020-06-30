package com.github.fourteam.pikachu.week1.junwoo.spring.domain;


import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Order;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.stereotype.Repository;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:24 오후
 */
@Repository
public interface PaymentRepository {
     void payment(Order order, Product product, Customer customer);
}
