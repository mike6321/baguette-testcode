package com.github.fourteam.sample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Name: 애노테이션 목 객체 학습테스트
 * Date: 2020/06/13
 * Info:
 *  [3rd week]
 * @Mock, @InjectMocks, @Spy 애노테이션 사용법을 학습한다.
 */
public class AnnotationMockTest {
    @Mock private List<String> mockProduct;
    @Spy @InjectMocks private OnlineShop mockObject;      // @InjectMocks은 @Mock이나 @Spy 객체를 자동으로 주입받는다.
    @Spy private OnlineShop spyObject;

    @Before
    public void setUp() {
        /*
        * Mockito Annotation을 사용하기 위해선 아래 세가지 중 하나를 반드시 해야한다.
        * 1. MockitoAnnotations.initMocks();
        * 2. @RunWith(MockitoJUnitRunner.class)
        * 3. @Role Annotation   ex) @Rule public MockitoRule rule = MockitoJUnit.rule();
        *
        * 이번 테스트에서는 1)의 방법으로 진행하였다.
        * */
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void spy객체_사용() {
        List<String> products = new ArrayList<>();
        products.add("bbubbush1");
        products.add("bbubbush2");
        products.add("bbubbush3");
        spyObject.setProducs(products);

        when(spyObject.canThisShopOpen()).thenReturn(Boolean.TRUE);

        assertTrue(spyObject.canThisShopOpen()); // 보유한 상품이 3개지만 true를 리턴
    }

    @Test
    public void mock_객체_사용() {
        // given
        doNothing().when(mockObject).setProducs(anyList());
        List<String> products = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            products.add("bbubbush" + i);
        }

        // when
        mockObject.setProducs(products);      // 상품을 주입 하지만 아무런 행동이 일어나지 않는다.

        // then
        assertFalse(mockObject.canThisShopOpen());   // when()으로 정의된 행동으로 동작
    }



}


