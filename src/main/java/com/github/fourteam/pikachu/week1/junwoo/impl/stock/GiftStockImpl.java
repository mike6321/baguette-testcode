package com.github.fourteam.pikachu.week1.junwoo.impl.stock;

import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.dto.gift.Gift;
import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import com.github.fourteam.pikachu.week1.junwoo.interfaces.stock.Stock;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:40 오전
 */
public class GiftStockImpl implements Stock {

    private final Gift gift;
    private final Customer customer;

    Map<Role, Boolean> roleStockCheck = new HashMap<>();

    public GiftStockImpl(Gift gift, Customer customer) {
        this.gift = gift;
        this.customer = customer;

        roleStockCheck.put(Role.EXECUTIVES, gift.getGiftStk() != 0);
        roleStockCheck.put(Role.GENERAL, gift.getGiftStk() == 0);
        roleStockCheck.put(Role.BLACKCONSUMER, false);
    }

    // TODO:  junwoochoi 2020/06/23 12:41 오전
    // 다만 일반고객은 사은품 재고가 없으면 주문할 수 없고, 임직원은 사은품이 존재하면 주문할 수 없다.
    // 추가로 블랙컨슈머는 당연히 주문할 수 없고, [추가 요구사항] 에 따라 추가된 협력사 고객은 사은품 재고가 10개 이상일 때만 주문 가능하다.
    @Override
    public boolean checkStock() {
        return roleStockCheck.get(customer.getRole());
    }


}
