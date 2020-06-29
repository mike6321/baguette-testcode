package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fourteam.pikachu.week1.junwoo.spring.application.AuthorityCheckExecutiveCustomerService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 9:53 오후
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AuthorityCheckExecutiveCustomerController.class)
public class AuthorityCheckExecutiveCustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthorityCheckExecutiveCustomerService authorityCheckExecutiveCustomerService;

    @Test
    public void checkRoleGeneralCustomerTest() throws Exception {
        Customer customer = new Customer("mike6321", Role.EXECUTIVES,30);

        when(authorityCheckExecutiveCustomerService.authorityCheck(customer)).thenReturn(true);

        mockMvc.perform(post("/authority/executive")
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