package com.github.fourteam.pikachu.week1.bbubbush.domain.customer;


import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;

public interface Cunsumer {
    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *
     */
    boolean checkCustomerStatus();

    /**
     * Name: 회원이 가진 포인트가 존재하는지 확인
     * Date: 2020/06/22
     * Info:
     *
     */
    boolean chkPoint();

    boolean checkGift(Product product);
}
