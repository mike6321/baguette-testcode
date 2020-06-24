package com.github.fourteam.pikachu.week1.bbubbush.domain.order;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;

public interface Order {

    boolean validationBeforeOrder(Cunsumer cunsumer, Product product);
}
