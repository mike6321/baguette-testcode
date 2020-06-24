package com.github.fourteam.pikachu.week1.bbubbush.domain.order;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

import java.util.List;

public class OnlineOrderSheet implements Order {

    @Override
    public boolean validationBeforeOrder(Cunsumer cunsumer, List<Product> products) {
        return false;
    }

    private boolean chkPrdListInfo(final Long cunsumerPoint, final List<Product> products) {
        return products.stream().filter(product -> cunsumerPoint > product.getPrice()).count() >= 10;
    }

    private boolean checkGift(final CustomerType customerType, final List<Product> products) {

        return false;
    }
}
