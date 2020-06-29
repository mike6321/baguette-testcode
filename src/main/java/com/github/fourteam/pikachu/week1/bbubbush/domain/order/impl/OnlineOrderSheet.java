package com.github.fourteam.pikachu.week1.bbubbush.domain.order.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Cunsumer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.order.Order;
import com.github.fourteam.pikachu.week1.bbubbush.domain.product.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

import java.util.List;

public class OnlineOrderSheet implements Order {

    private Cunsumer cunsumer;
    private List<Product> products;
    private long totalPaymentPrice;

    @Override
    public boolean validationBeforeOrder(Cunsumer cunsumer, List<Product> products) {
        this.cunsumer = cunsumer;
        this.products = products;
        this.totalPaymentPrice = sumProductsPrice();
        return chkPrdListInfo(cunsumer.getPoint(), products);
    }

    @Override
    public Cunsumer getCunsumer() {
        return cunsumer;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public long getTotalPaymentPrice() {
        return totalPaymentPrice;
    }

    private boolean chkPrdListInfo(final Long cunsumerPoint, final List<Product> products) {
        return products.stream().filter(product -> {
            return cunsumerPoint > product.getPrice();
        }).count() >= 10L;
    }
    private long sumProductsPrice(){
        return this.products.stream().mapToLong(product -> product.getPrice()).sum();
    }

}
