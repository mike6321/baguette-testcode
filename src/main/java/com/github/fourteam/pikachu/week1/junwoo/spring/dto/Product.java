package com.github.fourteam.pikachu.week1.junwoo.spring.dto;

import lombok.Builder;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:58 오후
 */
@Builder
public class Product {
    private Long prdId;
    private Integer prdStk;
    private Long giftId;
    private Integer giftStk;


    public Long getPrdId() {
        return prdId;
    }

    public Integer getPrdStk() {
        return prdStk;
    }

    public Long getGiftId() {
        return giftId;
    }

    public Integer getGiftStk() {
        return giftStk;
    }

    public Product(Long prdId, Integer prdStk, Long giftId, Integer giftStk) {
        this.prdId = prdId;
        this.prdStk = prdStk;
        this.giftId = giftId;
        this.giftStk = giftStk;
    }

    public Product() {

    }
}
