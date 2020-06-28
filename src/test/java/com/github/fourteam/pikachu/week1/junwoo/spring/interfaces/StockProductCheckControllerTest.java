package com.github.fourteam.pikachu.week1.junwoo.spring.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fourteam.pikachu.week1.junwoo.spring.application.StockProductCheckService;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Product;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:57 오후
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StockProductCheckController.class)
public class StockProductCheckControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StockProductCheckService stockProductCheckService;


    @Test
    public void StockProductCheckTest() throws Exception {
        Product product = Product.builder()
                                .prdId(12346544L)
                                .prdStk(30)
                                .build()
        ;
        when(stockProductCheckService.checkProductStock(product)).thenReturn(true);

        mockMvc.perform(post("/stock/product")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(product))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("prdId").exists())
                ;
    }
}