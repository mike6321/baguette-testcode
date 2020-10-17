package com.github.fourteam.pikachu.week1.junwoo.spring.dto;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:34 오후
 */
public class Order {

    private Pay pay;
    private Integer totalsum;

    public Pay getPay() {
        return pay;
    }

    public Integer getTotalsum() {
        return totalsum;
    }
}
