package com.github.fourteam.pikachu.week1.junwoo.spring;

import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 4:33 오후
 */
@SpringBootApplication
public class BaguetteApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaguetteApplication.class, args);
    }

    @Bean
    public Customer customer() {
        return new Customer();
    }
}
