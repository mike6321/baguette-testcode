package com.github.fourteam.pikachu.week1.junwoo.dto.product;

import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import lombok.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:22 오전
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"prdId"})
public class Product {
    private Integer prdId;
    private Integer prdStk;
}
