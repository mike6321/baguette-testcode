package com.github.fourteam.pikachu.week1.junwoo.spring.application;

import com.github.fourteam.pikachu.week1.junwoo.spring.domain.AuthorityCheckRepository;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Customer;
import com.github.fourteam.pikachu.week1.junwoo.spring.dto.Role;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 8:58 오후
 */
public class AutorityCheckCustomerServiceTest {


    AuthorityCheckRepository authorityCheckRepository = mock(AuthorityCheckRepository.class);

    @Test
    public void authorityGeneralCheck() {

        final AuthorityCheckGeneralCustomerService autorityCheckCustomerService = new AuthorityCheckGeneralCustomerService(authorityCheckRepository);

        Customer customer1 = new Customer("mike6321",Role.GENERAL,30);
        Customer customer2 = new Customer("mike6321",Role.BLACKCONSUMER,30);
        Customer customer3 = new Customer("mike6321",Role.EXECUTIVES,30);

        //given
        given(authorityCheckRepository.checkRole(customer1)).willReturn(true);
        given(authorityCheckRepository.checkRole(customer2)).willReturn(false);
        given(authorityCheckRepository.checkRole(customer3)).willReturn(true);

        //when
        final boolean result1 = autorityCheckCustomerService.authorityCheck(customer1);
        final boolean result2 = autorityCheckCustomerService.authorityCheck(customer2);
        final boolean result3 = autorityCheckCustomerService.authorityCheck(customer3);

        //then
        assertThat(result1,is(true));
        assertThat(result2,is(false));
        assertThat(result3,is(true));
    }

    @Test
    public void authorityExecutiveCheck() {
        final AuthorityCheckExecutiveCustomerService autorityCheckCustomerService = new AuthorityCheckExecutiveCustomerService(authorityCheckRepository);

        Customer customer1 = new Customer("mike6321",Role.EXECUTIVES,30);
        Customer customer2 = new Customer("mike6321",Role.EXECUTIVES,0);


        //given
        given(authorityCheckRepository.checkRole(customer1)).willReturn(true);
        given(authorityCheckRepository.checkRole(customer2)).willReturn(false);

        //when
        final boolean result1 = autorityCheckCustomerService.authorityCheck(customer1);
        final boolean result2 = autorityCheckCustomerService.authorityCheck(customer2);

        //then
        assertThat(result1,is(true));
        assertThat(result2,is(false));
    }
}