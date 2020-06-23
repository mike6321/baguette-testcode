package com.github.fourteam.pikachu.week1.junwoo.dto.gift;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:42 오전
 */
@Builder
//@Getter
public class Gift {
    private final Integer giftStk;
    private final Integer giftId;

    public Gift(Integer giftId, Integer giftStk) {
        this.giftId = giftId;
        this.giftStk = giftStk;
    }

    public Integer getGiftStk() {
        return giftStk;
    }
}
