package com.github.fourteam.pikachu.week1.junwoo.spring.application;


import com.github.fourteam.pikachu.week1.junwoo.spring.domain.PaymentRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Order;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.stereotype.Service;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:18 오후
 */
@Service
public class PaymentService {

    private PaymentRepository paymentRepository;

    public void payment(Order order, Product product, Customer customer) {
        paymentRepository.payment(order, product, customer);
    }
}
