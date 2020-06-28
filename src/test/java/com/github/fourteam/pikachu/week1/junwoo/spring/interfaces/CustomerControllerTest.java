package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.github.fourteam.pikachu.week1.junwoo.spring.application.CustomerService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:02 오후
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;


    @Test
    public void list() throws Exception {
        final List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("mike6321", Role.GENERAL,30));

        given(customerService.getCustomers()).willReturn(customers);

        mockMvc.perform(get("/Customer"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"userId\":\"mike6321\"")))
                .andExpect(content().string(containsString("\"role\":\"GENERAL\"")))
                .andExpect(content().string(containsString("\"point\":30")))
                .andExpect(content().string(containsString("\"userId\":\"mike6321\",\"role\":\"GENERAL\",\"point\":30")))
        ;
        //"userId":"mike6321"
        //"role":"GENERAL"
        //"point":30
        //"userId":"mike6321","role":"GENERAL","point":30
        //"role:":"GENERAL","point":30
    }

    @Test
    public void detail() throws Exception {
        final Customer customer = new Customer("mike6321", Role.GENERAL,30);
        given(customerService.getCustomer("mike6321")).willReturn(customer);

        mockMvc.perform(get("/Customer/mike6321"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"userId\":\"mike6321\"")))
                .andExpect(content().string(containsString("\"role\":\"GENERAL\"")))
                .andExpect(content().string(containsString("\"point\":30")))
                .andExpect(content().string(containsString("\"userId\":\"mike6321\",\"role\":\"GENERAL\",\"point\":30")))
        ;
    }

    //{"role":"GENERAL","point":30}
    @Test
    public void Create() throws Exception {

        Customer customer = new Customer("mike6321",Role.GENERAL,30);
        mockMvc.perform(post("/Customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"role\":\"GENERAL\",\"point\":30}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location","/Customer/mike6321"))
                .andExpect(content().string("{1234}"))

        ;
    }
}