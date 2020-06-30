package com.github.fourteam.pikachu.week1.imesung.domain.payment;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;

import java.text.ParseException;

public interface Payment {

    public boolean payment(Customer customer, Product product);

    public boolean checkCancelOrder() throws ParseException;

    public boolean cancelOrder();
}
