package com.github.fourteam.pikachu.week1.junwoo.dto.gift;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:42 오전
 */
public class Gift {
    private Long giftId;
    private Integer giftStk;

    public Gift(Long giftId, Integer giftStk) {
        this.giftId = giftId;
        this.giftStk = giftStk;
    }

    public Long getGiftId() {
        return giftId;
    }

    public Integer getGiftStk() {
        return giftStk;
    }
}
