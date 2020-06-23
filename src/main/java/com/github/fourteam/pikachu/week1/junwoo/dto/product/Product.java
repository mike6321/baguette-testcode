package com.github.fourteam.pikachu.week1.junwoo.dto.product;

import lombok.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:22 오전
 */
public class Product {
    private final Long prdId;
    private final Long prdStk;

    public Product(Long prdId, Long prdStk) {
        this.prdId = prdId;
        this.prdStk = prdStk;
    }

    public Long getPrdId() {
        return prdId;
    }

    public Long getPrdStk() {
        return prdStk;
    }
}
