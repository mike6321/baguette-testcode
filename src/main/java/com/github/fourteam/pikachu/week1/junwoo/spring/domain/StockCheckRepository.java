package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.stereotype.Repository;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:42 오후
 */
@Repository
public interface StockCheckRepository {
    boolean checkStock(Product product);
}
