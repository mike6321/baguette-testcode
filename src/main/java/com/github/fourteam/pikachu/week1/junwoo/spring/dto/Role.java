package com.github.fourteam.pikachu.week1.junwoo.spring.dto;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:13 오후
 */
public enum Role {

    GENERAL {
        @Override
        public boolean roleStockCheck(Product product) {
            return product.getGiftStk() != 0;
        }
    },
    EXECUTIVES {
        @Override
        public boolean roleStockCheck(Product product) {
            return product.getGiftStk() == 0;
        }
    },
    BLACKCONSUMER {
        @Override
        public boolean roleStockCheck(Product product) {
            return false;
        }
    };

    abstract public boolean roleStockCheck(Product product);
}
