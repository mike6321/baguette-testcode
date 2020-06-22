package com.github.fourteam.sample;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Name: Spy 객체 학습 테스트
 * Date: 2020/06/13
 * Info:
 *  [2nd week]
 *  Spy 객체는 Real Object의 특정 행동만 Mocking 할 수 있다.
 *  지정하지 않은 행동에 대해서는 실제 객체처럼 행동한다.
 */
public class SpyTest {
    private List<String> handlingTarget;
    @Before
    public void setUp() {
        handlingTarget = new ArrayList();
    }

    /**
     * Name: spy객체 사용하기
     * Date: 2020/06/13
     * Info:
     *  mock객체만큼 심플하다. when()으로 명시된 행동에 대해서는 mocking을 하고,
     *  정의되지 않은 행동을 객체의 방법대로 동작하게 만든다.
     */
    @Test
    public void spy객체_사용() {
        List<String> spy = spy(handlingTarget);
        when(spy.size()).thenReturn(100);   // when()으로 결과값을 정의

        spy.add("bbubbush1");
        spy.add("bbubbush2");
        spy.add("bbubbush3");

        assertThat(spy.get(0), is(equalTo("bbubbush1"))); // 실제 객체처럼 동작
        assertThat(spy.size(), is(equalTo(100)));   // mock 객체처럼 when()으로 정의된 행동으로 동작
    }
}
