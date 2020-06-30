package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustType;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.ExecutivesCust;
import com.github.fourteam.pikachu.week1.imesung.domain.product.GeneralProduct;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Gift;
import com.github.fourteam.pikachu.week1.imesung.domain.product.GiftProduct;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerTest {
    private List<Customer> customers = new ArrayList<>();

    @Before
    public void setUp() {
        customers.add(Customer.builder()
                .userId("mike6321")
                .userName("최준우")
                .custType(CustType.GENERAL)
                .point(2000L)
                .blackConsumerFlg(false)
                .build());

        customers.add(Customer.builder()
                .userId("mesung")
                .userName("임혜성")
                .custType(CustType.SUPPLIER)
                .point(1000L)
                .blackConsumerFlg(false)
                .supId("1001")
                .build());

        customers.add(Customer.builder()
                .userId("bbush")
                .userName("이상훈")
                .custType(CustType.EXCUTIVES)
                .point(1000L)
                .blackConsumerFlg(false)
                .build());
    }

    @Test
    public void 기본객체_생성확인() {
        //given
        Customer customer = customers.get(0);

        //when

        //then
        assertNotNull(customer);
        assertThat(customer.getUserId(), is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("mike6321")));
        assertThat(customer.getPoint(), is(equalTo(2000L)));
        assertThat(customer.getUserName(), is(equalTo("최준우")));
        assertFalse(customer.isBlackConsumerFlg());

    }

    @Test
    public void 협력사고객_권한확인() {
        //given
        GeneralProduct generalProduct = mock(GeneralProduct.class);
        Customer customer = customers.get(1);

        //when
        when(generalProduct.getStock()).thenReturn(3L);
        when(generalProduct.getSupId()).thenReturn("1001");


        //then
        assertThat(customer.getSupId(), is(equalTo(generalProduct.getSupId())));
        assertTrue(customer.chkSupCustGubun(generalProduct.getSupId(), generalProduct.getStock()));
    }

    @Test
    public void 임직원고객_권한확인() {
        //given
        Customer customer = ExecutivesCust.builder()
                .userId("bbush")
                .userName("이상훈")
                .custType(CustType.EXCUTIVES)
                .point(1000L)
                .blackConsumerFlg(false)
                .build();

        //when

        //then
        assertTrue(customer.chkCustomerGubun());
    }

    @Test
    public void 사은품_주문가능여부() {
        //given
        GiftProduct gift = mock(GiftProduct.class);
        Boolean[] chkOrderFlgFromGift = new Boolean[customers.size()];

        //when
        when(gift.getStock()).thenReturn(10L);
        for(int i = 0; i < customers.size(); i++) {
            chkOrderFlgFromGift[i] = customers.get(i).chkOrderFlgFromGift(gift.getStock());
        }

        //then
        assertTrue(chkOrderFlgFromGift[0]);
        assertTrue(chkOrderFlgFromGift[1]);
        assertFalse(chkOrderFlgFromGift[2]);

    }

    //3주차 요구사항 1. 현재 회원 자산 조회
    @Test
    public void 자산확인() {
        //given
        Customer customer = ExecutivesCust.builder()
                .userId("mesung")
                .userName("임혜성")
                .custType(CustType.EXCUTIVES)
                .point(1000L)
                .blackConsumerFlg(false)
                .build();

        //when

        //then
        assertTrue(customer.chkPoint());
    }


}