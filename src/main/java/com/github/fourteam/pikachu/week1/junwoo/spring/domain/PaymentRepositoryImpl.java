package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Order;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.stereotype.Component;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:26 오후
 */
@Component
public class PaymentRepositoryImpl implements PaymentRepository{

    @Override
    public void payment(Order order, Product product, Customer customer) {
        //if (customer.getPoint())
    }


    private Integer paymentPoint(Order order, Customer customer) {
        return order.getTotalsum() - customer.getPoint();
    }

}
