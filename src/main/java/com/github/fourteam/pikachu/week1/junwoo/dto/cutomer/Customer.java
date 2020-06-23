package com.github.fourteam.pikachu.week1.junwoo.dto.cutomer;

import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import lombok.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:17 오후
 */
@Builder
@AllArgsConstructor
public class Customer {
    private String userId;
    private Role role;
    private Integer point;

    public Role getRole() {
        return role;
    }

    public Integer getPoint() {
        return point;
    }


}
