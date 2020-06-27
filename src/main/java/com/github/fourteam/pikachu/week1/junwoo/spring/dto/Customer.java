package com.github.fourteam.pikachu.week1.junwoo.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:17 오후
 */
@AllArgsConstructor
public class Customer {
    private String userId;
    private Role role;
    private Integer point;

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }

    public Integer getPoint() {
        return point;
    }

}
