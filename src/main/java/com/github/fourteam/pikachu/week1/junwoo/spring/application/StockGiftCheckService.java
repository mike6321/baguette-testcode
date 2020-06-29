package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.StockCheckRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:58 오후
 */
@Service
public class StockGiftCheckService {

    private StockCheckRepository stockCheckRepository;

    public StockGiftCheckService(@Qualifier("stockGiftCheckRepositoryImpl") StockCheckRepository stockCheckRepository) {
        this.stockCheckRepository = stockCheckRepository;
    }

    public boolean checkGiftStock(Product product) {
        return stockCheckRepository.checkStock(product);
    }
}
