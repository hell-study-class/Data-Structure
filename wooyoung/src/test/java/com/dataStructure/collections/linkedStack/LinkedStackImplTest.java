package com.dataStructure.collections.linkedStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedStackImplTest {

    @Test
    void test() {
        // given
        LinkedStack stack = new LinkedStackImpl();
        Object push1 = stack.push(1);
        Object pop1 = stack.pop();

        Object push2 = stack.push(2);
        Object push3 = stack.push(3);

        Object pop2 = stack.pop();
        Object pop3 = stack.pop();

        // when

        // then
        Assertions.assertEquals(push1, pop1);
        Assertions.assertEquals(push2, pop3);
        Assertions.assertEquals(push3, pop2);
    }

    @Test
    void 스택에_1개_값을_삽입_후_비교한다() {
        // given
        LinkedStack stack = new LinkedStackImpl();

        // when
        stack.push(1);

        // then
        Assertions.assertEquals(1, stack.size());
        Assertions.assertEquals(1, stack.peek());
    }

    @Test
    void 스택에_2개_값을_삽입_후_비교한다() {
        // given
        LinkedStack stack = new LinkedStackImpl();

        // when
        Object pop1 = stack.push(1);
        Object pop2 = stack.push(2);

        // then
        Assertions.assertEquals(2, pop2);
        Assertions.assertEquals(1, pop1);
    }

    @Test
    void 특정_원소의_위치를_확인한다() {
        // given
        LinkedStack stack = new LinkedStackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // when
        int index1 = stack.search(3);
        int index2 = stack.search(2);
        int index3 = stack.search(1);

        // then
        Assertions.assertEquals(index1, 1);
        Assertions.assertEquals(index2, 2);
        Assertions.assertEquals(index3, 3);
    }

    @Test
    void 길이가_0일때_삭제하면_예외를_던진다() {
        // given
        LinkedStack stack = new LinkedStackImpl();

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> stack.pop());
    }

    @Test
    void 스택이_비어있는지_확인한다() {
        // given
        LinkedStack stack = new LinkedStackImpl();
        // when

        // then
        Assertions.assertEquals(stack.empty(), true);
    }

    @Test
    void 데이터_인덱스_위치를_조회한다() {
        // given

        // when

        // then
    }

    @Test
    void 데이터_20개를_저장한다() {
        // given

        // when

        // then
    }

    @Test
    void 데이터_40개를_저장한다() {
        // given

        // when

        // then
    }

}