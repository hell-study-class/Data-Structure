package com.dataStructure.collections.arrayStack;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayStackImplTest {

    @Test
    void 스택에_넣은_값을_비교한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();

        // when
        Object p1 = stack.push(1);
        Object p2 = stack.push(2);

        // then
        Assertions.assertEquals(p1, 1);
        Assertions.assertEquals(p2, 2);
    }

    @Test
    void 스택에서_삭제한_값을_비교한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();
        Object push1 = stack.push(1);
        Object push2 = stack.push(2);

        // when
        Object pop1 = stack.pop();
        Object pop2 = stack.pop();

        // then
        Assertions.assertEquals(push2, pop1);
        Assertions.assertEquals(push1, pop2);
    }

    @Test
    void 길이가_0일때_삭제하면_예외를_던진다() {
        // given
        ArrayStack stack = new ArrayStackImpl();

        // when

        // then
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> stack.pop());
    }

    @Test
    void 스택이_비어있는지_확인한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();

        // when

        // then
        Assertions.assertEquals(stack.empty(), true);
    }

    @Test
    void 데이터_인덱스_위치를_조회한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // when
        int search1 = stack.search(2);
        int search2 = stack.search(3);

        // then
        Assertions.assertEquals(search1, 2);
        Assertions.assertEquals(search2, 3);
    }

    @Test
    void 데이터_20개를_저장한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();
        IntStream.rangeClosed(1, 20).forEach(e -> stack.push(e));

        // when

        // then
        Assertions.assertEquals(stack.size(), 20);
        for (int i = 20; i > 0; i--) {
            Assertions.assertEquals(stack.pop(), i);
        }
    }

    @Test
    void 데이터_40개를_저장한다() {
        // given
        ArrayStack stack = new ArrayStackImpl();
        IntStream.rangeClosed(1, 40).forEach(e -> stack.push(e));

        // when

        // then
        Assertions.assertEquals(stack.size(), 40);
        for (int i = 40; i > 0; i--) {
            Assertions.assertEquals(stack.pop(), i);
        }
    }


}