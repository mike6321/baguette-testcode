package com.github.fourteam.sample;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Name: Mock 객체 주입에 대한 학습 테스트
 * Date: 2020/06/13
 * Info:
 *  [2nd week]
 *  객체가 참조하는 다른 객체를 Mocking 하는 방법을 학습한다.
 */
public class InjectMocksTest {
    private OnlineShop shop;

    @Before
    public void setUp() {
        shop = new OnlineShop();
    }

    /**
     * Name: 의존성을 주입하지 않는 경우
     * Date: 2020/06/13
     * Info:
     *  NPE가 발생한다. OnlineShop.getProductNames()이 내부 products 객체에 의존하기 때문이다.
     *  우리는 OnlineShop 객체를 테스트하고 싶다...
     */
    @Test(expected = NullPointerException.class)
    public void 상품이_없는경우(){
        assertFalse(shop.canThisShopOpen());
    }

    /**
     * Name: Mock객체로 Mocking하기
     * Date: 2020/06/13
     * Info:
     *  실제 객체 대신 목 객체를 통해 OnlineShop 객체의 테스트를 진행한다.
     *  이런 경우 product가 또다른 의존성을 가져도 product가 제공하는 행동만 when으로 명시하면
     *  아무 신경을 쓰지 않아도 된다.
     */
    @Test
    public void mock_객체를_주입() {
        List<String> product = mock(List.class); // mock 객체를 생성
        shop.setProducs(product);               // 주입
        when(product.size()).thenReturn(10);    // mock 객체의 size()를 호출하면 10을 리턴

        // when
        boolean shopDestiny = shop.canThisShopOpen();
        
        assertTrue(shopDestiny);
        verify(product, atLeastOnce()).size();
    }
}