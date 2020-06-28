package com.github.fourteam.pikachu.week1.junwoo.spring.application;


import com.github.fourteam.pikachu.week1.junwoo.spring.domain.StockCheckRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:49 오후
 */
public class StockProductCheckServiceTest {

    StockCheckRepository stockCheckRepository = mock(StockCheckRepository.class);

    @Test
    public void stockProductCheck() {

        final StockProductCheckService stockProductCheckService = new StockProductCheckService(stockCheckRepository);

        Product product1 = Product.builder()
                                    .prdId(1234L)
                                    .prdStk(30)
                                    .build()
        ;
        Product product2 = Product.builder()
                                    .prdId(1234L)
                                    .prdStk(0)
                                    .build()
                                    ;


        //given
        given(stockCheckRepository.checkStock(product1)).willReturn(true);
        given(stockCheckRepository.checkStock(product2)).willReturn(false);

        //when
        boolean result1 = stockProductCheckService.checkProductStock(product1);
        boolean result2 = stockProductCheckService.checkProductStock(product2);

        //then
        assertThat(result1, is(true));
        assertThat(result2, is(false));
    }
}