package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.StockProductCheckService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:46 오후
 */
@Controller
@RequestMapping(value = "/stock/product", produces = MediaTypes.HAL_JSON_VALUE)
public class StockProductCheckController {

    StockProductCheckService stockProductCheckService;

    public StockProductCheckController(StockProductCheckService stockProductCheckService) {
        this.stockProductCheckService = stockProductCheckService;
    }

    @PostMapping
    public ResponseEntity checkProductStock(@RequestBody Product product) {

        stockProductCheckService.checkProductStock(product);

        URI createdUri = linkTo(StockProductCheckController.class).slash(product.getGiftId()).toUri();

        return ResponseEntity.created(createdUri).body(product);
    }
}
