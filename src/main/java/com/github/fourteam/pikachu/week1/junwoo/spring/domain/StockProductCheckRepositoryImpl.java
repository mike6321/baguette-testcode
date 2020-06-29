package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
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
@Qualifier("stockProductCheckRepositoryImpl")
public class StockProductCheckRepositoryImpl implements StockCheckRepository{
    @Override
    public boolean checkStock(Product product) {
        return product.getPrdStk() != 0;
    }

}
