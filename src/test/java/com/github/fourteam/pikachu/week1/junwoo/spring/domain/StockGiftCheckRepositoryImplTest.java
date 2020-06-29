package com.github.fourteam.pikachu.week1.junwoo.spring.domain;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:29 오후
 */
public class StockGiftCheckRepositoryImplTest {

    private StockCheckRepository stockCheckRepository;

    @Test
    public void checkGiftStockTest() {

        Customer generalCustomer = new Customer("mike6321", Role.GENERAL,30);
        Customer executiveCustomer = new Customer("mike6321", Role.EXECUTIVES,30);
        Customer blackConsumerCustomer = new Customer("mike6321", Role.BLACKCONSUMER,30);

        //상품권의 재고가 있는 경우
        Product product1 = Product.builder()
                                .giftId(1234L)
                                .giftStk(20)
                                .build()
        ;
        //상품권의 재고가 있는 경우
        Product product2 = Product.builder()
                .giftId(1234L)
                .giftStk(0)
                .build()
        ;


        //given
        stockCheckRepository = new StockGiftCheckRepositoryImpl(generalCustomer);

        //when
        boolean result = stockCheckRepository.checkStock(product1);

        //then
        assertThat(result, is(true));


        //given
        stockCheckRepository = new StockGiftCheckRepositoryImpl(executiveCustomer);

        //when
        boolean result2 = stockCheckRepository.checkStock(product2);

        //then
        assertThat(result2, is(true));


        //given
        stockCheckRepository = new StockGiftCheckRepositoryImpl(blackConsumerCustomer);

        //when
        boolean result3 = stockCheckRepository.checkStock(product2);

        //then
        assertThat(result3, is(false));


    }
}