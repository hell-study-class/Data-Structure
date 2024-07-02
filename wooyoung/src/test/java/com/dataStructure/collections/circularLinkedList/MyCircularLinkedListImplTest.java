package com.dataStructure.collections.circularLinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyCircularLinkedListImplTest {

    Random rnd = new Random();

    @Test
    @DisplayName("첫 번째 데이터가 정상적으로 저장되는 지 확인합니다.")
    public void assertAddOnceData() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();

        // when
        list.add(1);
        list.add(2);
        list.add(0, 3);

        // then
        Assertions.assertEquals(list.get(0), 3);
        Assertions.assertEquals(list.get(1), 1);
        Assertions.assertEquals(list.get(2), 2);
    }

    @Test
    @DisplayName("10개의 데이터가 정상적으로 저장되는 지 확인합니다.")
    public void asserAddByManyData() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        int[] data = {0, 1, 2, 3, 4};
        Arrays.stream(data).forEach(d -> list.add(d));

        // when
        int size = list.size();

        // then
        IntStream.range(0, data.length).forEach(i -> {
            Assertions.assertEquals(list.get(i), data[i]);
        });
        Assertions.assertEquals(size, data.length);
    }

    @Test
    @DisplayName("리스트가 비어있으면 true를 반환합니다.")
    public void assertIsEmptySuccess() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();

        // when
        boolean empty = list.isEmpty();

        // then
        Assertions.assertTrue(empty);
    }

    @Test
    @DisplayName("리스트가 비어있으면 false를 반환합니다.")
    public void assertIsEmptyFail() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(10);

        // when
        boolean empty = list.isEmpty();

        // then
        Assertions.assertFalse(empty);
    }

    @Test
    @DisplayName("indexOf 메서드를 통해 데이터의 첫 번째 index 번호를 조회합니다.")
    public void assertIndexOf() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(3);
        list.add(2);

        // when
        int index = list.indexOf(2);

        // then
        Assertions.assertEquals(index, 1);
    }

    @Test
    @DisplayName("lastIndexOf 메서드를 통해 데이터의 마지막 index 번호를 조회합니다.")
    public void assertLastIndexOf() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(10);
        list.add(3);
        list.add(2);

        // when
        int index = list.lastIndexOf(2);

        // then
        Assertions.assertEquals(index, 5);
    }

    @Test
    @DisplayName("빈 리스트일 때 indexOf, lastIndexOf 메서드를 호출하면 예외를 던집니다.")
    public void assertIndexOfByEmptyList() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();

        // when

        // then
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.indexOf(1));
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.lastIndexOf(1));
    }

    @Test
    @DisplayName("존재하지 않는 데이터 값과 함께 indexOf, lastIndexOf 메서드를 호출하면 예외를 던집니다.")
    public void assertIndexOfNoData() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // when

        // then
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.indexOf(4));
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.lastIndexOf(4));
    }

    @Test
    @DisplayName("삭제할 데이터가 없으면 false를 반환합니다.")
    public void assertRemove() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();

        // when
        boolean isRemove = list.remove((Integer) 1);

        // then
        Assertions.assertFalse(isRemove);
    }

    @Test
    @DisplayName("asd")
    public void assertRemoveasd() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();

        // when
        boolean isRemove = list.remove((Integer) 1);

        // then
        Assertions.assertFalse(isRemove);
    }

    @Test
    @DisplayName("첫 번째 객체의 값을 가진 데이터를 삭제합니다.")
    public void assertRemoveFirstObject() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);

        // when
        list.remove((Integer) 1);

        // then
        Assertions.assertEquals(list.get(0), 1);
        Assertions.assertEquals(list.get(1), 2);
        Assertions.assertEquals(list.get(2), 1);
    }

    @Test
    @DisplayName("마지막 객체의 데이터를 삭제합니다.")
    public void assertRemoveLastObject() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        list.remove((Integer) 3);

        // then
        Assertions.assertEquals(list.get(0), 1);
        Assertions.assertEquals(list.get(1), 2);
        Assertions.assertEquals(list.get(2), 1);
    }

    @Test
    @DisplayName("데이터가 포함되어있으면 true를 반환합니다.")
    public void assertContainsSuccess() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);

        // when
        boolean contains = list.contains(1);

        // then
        Assertions.assertTrue(contains);
    }

    @Test
    @DisplayName("데이터가 포함되어있으면 false 반환합니다.")
    public void assertContainsFalse() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);

        // when
        boolean contains = list.contains(2);

        // then
        Assertions.assertFalse(contains);
    }

    @Test
    @DisplayName("특정 인덱스에 위치한 데이터의 값을 변경합니다.")
    public void assertSet() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);

        // when
        list.set(0, 100);

        // then
        Assertions.assertEquals(list.get(0), 100);
    }

    @Test
    @DisplayName("인덱스 범위를 벗어나면 예외를 던집니다.")
    public void assertSetByIndexOutBound() {
        // given
        MyCircularLinkedList<Integer> list = new MyCircularLinkedListImpl<>();
        list.add(1);
        list.add(2);

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.set(-1, 10));
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.set(list.size(), 10));
    }

}