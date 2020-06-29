package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:45 오후
 */
@Component
@Qualifier("stockGiftCheckRepositoryImpl")
public class StockGiftCheckRepositoryImpl implements StockCheckRepository{

    private Customer customer;

    @Autowired(required = false)
    public StockGiftCheckRepositoryImpl(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean checkStock(Product product) {

        return customer.getRole().roleStockCheck(product);
    }

}
