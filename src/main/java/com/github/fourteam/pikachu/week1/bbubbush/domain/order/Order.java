package com.github.fourteam.pikachu.week1.bbubbush.domain.order;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;

import java.util.List;

public interface Order {
    boolean validationBeforeOrder(Cunsumer cunsumer, List<Product> products);
}
