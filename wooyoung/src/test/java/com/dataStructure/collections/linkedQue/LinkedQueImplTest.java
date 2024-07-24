package com.dataStructure.collections.linkedQue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedQueImplTest {

    @Test
    void 큐_삽입_테스트() {
        // given
        LinkedQue q = new LinkedQueImpl();

        // when
        q.offer(1);

        // then
        Assertions.assertEquals(1, q.peek());
    }

    @Test
    void 큐_삭제_테스트() {
        // given
        LinkedQue q = new LinkedQueImpl();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        // when

        // then
        Assertions.assertEquals(1, q.poll());
        Assertions.assertEquals(2, q.poll());
        Assertions.assertEquals(3, q.poll());
    }

    @Test
    void 길이가_0일때_삭제하면_예외를_던진다() {
        // given
        LinkedQue q = new LinkedQueImpl();

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> q.poll());
    }

}