package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.StockGiftCheckService;
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
@RequestMapping(value = "/stock/gift", produces = MediaTypes.HAL_JSON_VALUE)
public class StockGiftCheckController {

    StockGiftCheckService stockGiftCheckService;

    public StockGiftCheckController(StockGiftCheckService stockGiftCheckService) {
        this.stockGiftCheckService = stockGiftCheckService;
    }

    @PostMapping
    public ResponseEntity checkProductStock(@RequestBody Product product) {

        stockGiftCheckService.checkGiftStock(product);

        URI createdUri = linkTo(StockProductCheckController.class).slash(product.getPrdId()).toUri();

        return ResponseEntity.created(createdUri).body(product);
    }
}
