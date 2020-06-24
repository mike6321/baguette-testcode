package com.github.fourteam.pikachu.week1.bbubbush.domain.order;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

import java.util.List;

public class OnlineOrderSheet implements Order {

    @Override
    public boolean validationBeforeOrder(Cunsumer cunsumer, List<Product> products) {
        return chkPrdListInfo(cunsumer.getPoint(), products);
    }

    private boolean chkPrdListInfo(final Long cunsumerPoint, final List<Product> products) {
        return products.stream().filter(product -> {
            return cunsumerPoint > product.getPrice();
        }).count() >= 10L;
    }

}
