package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.AuthorityCheckGeneralCustomerService;
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
 * Time : 5:00 오후
 */
@Controller
@RequestMapping(value = "/authority/general", produces = MediaTypes.HAL_JSON_VALUE)
public class AuthorityCheckGeneralCustomerController {

    private AuthorityCheckGeneralCustomerService authorityCheckGeneralCustomerService;

    public AuthorityCheckGeneralCustomerController(AuthorityCheckGeneralCustomerService authorityCheckGeneralCustomerService) {
        this.authorityCheckGeneralCustomerService = authorityCheckGeneralCustomerService;
    }

    @PostMapping
    public ResponseEntity checkRoleGeneralCustomer(@RequestBody Customer customer) {
        this.authorityCheckGeneralCustomerService.authorityCheck(customer);

        URI createdUri = linkTo(AuthorityCheckGeneralCustomerController.class).slash(customer.getUserId()).toUri();

        return ResponseEntity.created(createdUri).body(customer);
    }
}
