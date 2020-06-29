package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.AuthorityCheckExecutiveCustomerService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
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
 * Time : 9:50 오후
 */
@Controller
@RequestMapping(value = "/authority/executive", produces = MediaTypes.HAL_JSON_VALUE)
public class AuthorityCheckExecutiveCustomerController {
    AuthorityCheckExecutiveCustomerService authorityCheckExecutiveCustomerService;

    public AuthorityCheckExecutiveCustomerController(AuthorityCheckExecutiveCustomerService authorityCheckExecutiveCustomerService) {
        this.authorityCheckExecutiveCustomerService = authorityCheckExecutiveCustomerService;
    }

    @PostMapping
    public ResponseEntity checkRoleExecutiveCustomer(@RequestBody Customer customer) {
        this.authorityCheckExecutiveCustomerService.authorityCheck(customer);

        URI createdUri = linkTo(AuthorityCheckExecutiveCustomerController.class).slash(customer.getUserId()).toUri();

        return ResponseEntity.created(createdUri).body(customer);
    }
}
