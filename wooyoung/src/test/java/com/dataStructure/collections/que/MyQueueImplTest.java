package com.dataStructure.collections.que;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyQueueImplTest {

    @Test
    void assertOffer() {
        // given
        MyQueue<Integer> q = new MyQueueImpl<>();

        // when
        q.offer(1);
        q.offer(2);
        q.offer(3);

        // then
        Assertions.assertEquals(q.size(), 3);
    }

    @Test
    void assertPoll() {
        // given
        MyQueue<Integer> q = new MyQueueImpl<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        // when
        Integer v1 = q.poll();
        Integer v2 = q.poll();
        Integer v3 = q.poll();

        // then
        Assertions.assertEquals(v1, 1);
        Assertions.assertEquals(v2, 2);
        Assertions.assertEquals(v3, 3);
        Assertions.assertEquals(q.size(), 0);
    }

    @Test
    void assertPeek() {
        // given
        MyQueue<Integer> q = new MyQueueImpl<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);

        // when
        Integer v1 = q.peek();

        // then
        Assertions.assertEquals(v1, 3);
        Assertions.assertEquals(q.size(), 2);
    }

    @Test
    void assertResize() {
        // given
        MyQueue<Integer> q = new MyQueueImpl<>();
        for (int i = 1; i <= 10; i++) {
            q.offer(i);
        }

        // when
        q.offer(11);

        // then
        Assertions.assertEquals(q.peek(), 11);
        Assertions.assertEquals(q.size(), 10);
    }

    @Test
    void assertClear() {
        // given
        MyQueue<Integer> q = new MyQueueImpl<>();
        for (int i = 1; i <= 10; i++) {
            q.offer(i);
        }

        // when
        q.clear();

        // then
        Assertions.assertEquals(q.size(), 0);
    }
}