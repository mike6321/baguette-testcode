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
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"userId"})
public class Customer {
    private String userId;
    private String userName;
    private Role role;
    private Integer point;


}
