package com.github.fourteam.sample;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Name: 기본 Mock 객체 학습테스트
 * Date: 2020/06/13
 * Info:
 *  [1st week]
 *  가장 간단한 형태의 Mock 객체 사용법을 학습한다.
 */
public class BasicMockitoTest {

    private Map<String, String> mockMap;

    @Before
    public void setUp() {
        mockMap = mock(HashMap.class);
    }

    /**
     * Name: mockMap_일반객체처럼_사용
     * Date: 2020/06/04
     * Info:
     *  mock 객체는 일반 객체처럼 사용하면 안된다. 내부의 메서드를 호출해도 default data value를 리턴한다.
     */
    @Test
    public void mockMap_일반객체처럼_사용() {
        mockMap.put("userId", "bbubbush");
        mockMap.put("userName", "lsh");

        assertThat(mockMap.get("userId"), is(nullValue()));
        assertThat(mockMap.get("userName"), is(nullValue()));
    }

    /**
     * Name: mockMap_스터빙하기
     * Date: 2020/06/04
     * Info:
     *  mock 객체는 어떤 상황일 때, 어떤 행동을 하는지 명시해줘야한다.
     *  mock 객체의 기본 개념이 stub 객체를 보완하기 위해 등장했으므로, 구현된 값으로만 동작하는 stub 객체와 다르게 stub 영역의 값을 채워 넣을 수 있다.
     */
    @Test(expected = RuntimeException.class)
    public void mockMap_스터빙하기() {
        when(mockMap.get("userId")).thenReturn("bbubbush");
        when(mockMap.get("userName")).thenReturn("lsh");
        when(mockMap.get("age")).thenThrow(RuntimeException.class);

        assertThat(mockMap.get("userId"), is(equalTo("bbubbush")));
        assertThat(mockMap.get("userName"), is(equalTo("lsh")));
        mockMap.get("age"); // throw RuntimeException;
    }

    /**
     * Name: mockMap_스터빙_응용하기
     * Date: 2020/06/04
     * Info:
     *   참고하면 좋을 소스코드. 봐도 잘 모를땐 doc을 찾아보자.
     */
    @Test
    public void mockMap_스터빙_응용하기() {
        when(mockMap.get(anyString())).thenReturn("bbubbush");
        when(mockMap.get(eq("age"))).thenReturn("31");
        when(mockMap.containsKey(anyString())).thenCallRealMethod();
        
        assertThat(mockMap.get("userId"), is(equalTo("bbubbush")));
        assertThat(mockMap.get("userName"), is(equalTo("bbubbush")));
        assertThat(mockMap.get("age"), is(equalTo("31")));
        assertThat(mockMap.containsKey("age"), is(Boolean.FALSE));

        // 만약 실제로 값을 넣는다면?
        mockMap.put("age", "31");
        when(mockMap.put("age", "31")).thenCallRealMethod();
        assertThat(mockMap.containsKey("age"), is(Boolean.FALSE));  // 영향이 없다.  즉 thenCallRealMethod()는 stub 메서드 리턴값의 default value를 리턴해준다.
    }

    /**
     * Name: mockMap_검증하기
     * Date: 2020/06/04
     * Info:
     *  mock 객체를 검증하는 verify.
     *  읽는 방법은 다음과 같다.
     *    ex) verify(mockMap, times(0)).get("userName");  =>  mockMap에 대해 검증한다. get("userName") 이라는 메서드를 0번 실행했다는 것을.
     *  즉, varify() 이후에 나오는 문법에 대해 mock 객체가 몇 번 실행했는지, 시간 내에 끝냈는지에 대해 검증 가능하다.
     *
     *  times()를 생략하면 기본적으로 한 번 호출한 것으로 검증한다.
     */
    @Test
    public void mockMap_검증하기() {
        // given
        when(mockMap.get("userId")).thenReturn("bbubbush");
        when(mockMap.get("userName")).thenReturn("lsh");

        // when
        mockMap.get("userId");
        mockMap.getOrDefault("userId", "-_-");
        mockMap.getOrDefault("userId", "-_-");

        // then
        verify(mockMap).get("userId");
        verify(mockMap, times(0)).get("userName");
        verify(mockMap, times(1)).get(anyString());
        verify(mockMap, times(0)).getOrDefault("userId", "");
        verify(mockMap, times(2)).getOrDefault("userId", "-_-");
        verify(mockMap, never()).clear();
        verify(mockMap, atLeastOnce()).get("userId");
        verify(mockMap, atLeast(2)).getOrDefault("userId", "-_-");
        verify(mockMap, atMost(1)).clear();
    }

    /**
     * Name: mockMap_리턴값이없는객체_검증하기
     * Date: 2020/06/04
     * Info:
     *  return type == void 인 메서드에 대해 when()을 설정하는 방법이다. 다만, reutrn type이 없는 만큼 검증할 수 있는 방법이 제한적이다.
     *
     *  1) doThrow()
     *  2) doNothing()
     *
     *  doNothing()은 정말 아무것도 안하기 떄문에 doThrow()를 통해 정말 동작하는지 테스트를 진행했다.
     */
    @Test(expected = RuntimeException.class)
    public void mockMap_리턴값이없는객체_검증하기() {
        // return type == void 인 객체는 위 문법이 불가능하다. 따라서 다른 방식으로 mock 객체를 핸들링한다.
//        when(mockMap.clear())...
        doThrow(RuntimeException.class).when(mockMap).clear();

        // when
        mockMap.clear();    // throw RuntimeException
    }
}
