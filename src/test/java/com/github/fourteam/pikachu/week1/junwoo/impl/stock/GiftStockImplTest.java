package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.dto.gift.Gift;
import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import org.junit.Test;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:47 오전
 */
public class GiftStockImplTest {

    // TODO:  junwoochoi 2020/06/23 12:41 오전
    // 다만 일반고객은 사은품 재고가 없으면 주문할 수 없고, 임직원은 사은품이 존재하면 주문할 수 없다.

    private GiftStockImpl giftStock;
    private Gift gift;
    private Customer customer;

    @Test
    public void checkGiftStck() {
        Gift giftMock = gift.builder().giftId(1234)
                            .giftStk(3)
                            .build()
        ;

        Customer customerMock = this.customer.builder().userId("jw")
                .role(Role.GENERAL)
                .point(30)
                .build();


        giftStock = new GiftStockImpl(giftMock, customerMock);

        giftStock.checkStock();
    }
}