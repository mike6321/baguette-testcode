package com.github.fourteam.pikachu.week1.junwoo.spring.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private Integer giftId;
    private Integer giftStk;


    public Long getPrdId() {
        return prdId;
    }

    public Integer getPrdStk() {
        return prdStk;
    }

    public Product(Long prdId, Integer prdStk, Integer giftId, Integer giftStk) {
        this.prdId = prdId;
        this.prdStk = prdStk;
        this.giftId = giftId;
        this.giftStk = giftStk;
    }

    public Product() {

    }
}
