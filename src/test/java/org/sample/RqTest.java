package org.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RqTest {
    @Test
    @DisplayName("수정?id=1")
    void t1() {
        Rq rq = new Rq("수정?id=1");

        String actionName= rq.getActionName();

        assertEquals("수정", actionName);
    }

    @Test
    @DisplayName("삭제?id=1")
    void t2() {
        Rq rq = new Rq("삭제?id=1");

        String actionName= rq.getActionName();

        assertEquals("삭제", actionName);
    }
    @Test
    @DisplayName("등록?이름=홍길동, getParam()")
    void t3() {
        Rq rq  = new Rq("등록?이름=홍길동");
        String name = rq.getParam("이름", "");

        assertEquals("홍길동", name);
    }

    @Test
    @DisplayName("등록?고향=남원, getParam()")
    void t4() {
        Rq rq  = new Rq("등록?고향=남원");
        String name = rq.getParam("고향", "");

        assertEquals("남원", name);
    }

    @Test
    @DisplayName("등록?이름=홍길동&고향=남원, getParam()")
    void t5() {
        Rq rq  = new Rq("등록?이름=홍길동&고향=남원");
        String name = rq.getParam("이름", "");

        assertEquals("남원", name);
    }
}