package com.github.fourteam.pikachu.week1.junwoo.dto.product;

import lombok.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:22 오전
 */
@Builder
//@Getter
public class Product {
    private final Long prdId;
    private final Integer prdStk;

    public Product(Long prdId, Integer prdStk) {
        this.prdId = prdId;
        this.prdStk = prdStk;
    }

    public Integer getPrdStk() {
        return prdStk;
    }
}
