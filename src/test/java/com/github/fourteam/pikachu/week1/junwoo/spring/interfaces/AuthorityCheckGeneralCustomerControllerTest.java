package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fourteam.pikachu.week1.junwoo.spring.application.AuthorityCheckGeneralCustomerService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:43 오후
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AuthorityCheckGeneralCustomerController.class)
public class AuthorityCheckGeneralCustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private AuthorityCheckGeneralCustomerService authorityCheckGeneralCustomerService;

    @Test
    public void checkRoleGeneralCustomerTest() throws Exception {

        Customer customer = new Customer("mike6321", Role.GENERAL,30);

        when(authorityCheckGeneralCustomerService.authorityCheck(customer)).thenReturn(true);

        mockMvc.perform(post("/authority/general")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(customer))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("userId").exists())
        ;
    }

}