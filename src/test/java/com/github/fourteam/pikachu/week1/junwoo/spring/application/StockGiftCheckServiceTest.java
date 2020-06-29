package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:09 오후
 */
public class StockGiftCheckServiceTest {

    //StockCheckRepository stockCheckRepository = mock(StockCheckRepository.class);

    @Test
    public void stockGiftCheck() {

        //일반고객이 사은품의 재고가 존재하지 않을 때 - 주문 불가
        Product product = Product.builder()
                                .giftId(1234L)
                                .giftStk(0)
                                .build()
        ;
        Customer customer = new Customer("mike6321", Role.GENERAL,30);


        //given
        final StockGiftCheckService stockGiftCheckService = mock(StockGiftCheckService.class);

        //when
        stockGiftCheckService.checkGiftStock(product);

        //then
        verify(stockGiftCheckService, times(1)).checkGiftStock(product);

    }

}