package com.dataStructure.collections.linkedList;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyLinkedListImplTest {

    Random rnd = new Random();

    @Test
    @DisplayName("0~9 까지 입력 데이터를 검증합니다.")
    public void add() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();

        // when
        IntStream.range(0, 10).forEach(i -> linkedList.add(i));

        // then
        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(i, linkedList.get(i));
        }
    }

    @Test
    @DisplayName("조회 시 0 미만 인덱스를 입력하면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertAddByIndexLessThanZero() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> linkedList.get(-1), "인덱스 값은 배열 범위를 초과했습니다.");

    }

    @Test
    @DisplayName("조회 시 배열 크기를 초과한 인덱스를 입력하면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertAddByIndexGreaterThanSize() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> linkedList.get(1), "인덱스 값은 배열 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("첫번째 원소 조회를 확인합니다.")
    public void getFirst() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{1, 4, 5, 2, 6};

        // when
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // then
        Assertions.assertEquals(linkedList.getFirst(), testData[0]);
    }

    @Test
    @DisplayName("마지막 원소 조회를 확인합니다.")
    public void getLast() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{1, 4, 5, 2, 6};

        // when
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // then
        Assertions.assertEquals(linkedList.getLast(), testData[testData.length - 1]);
    }

    @Test
    @DisplayName("초기화 후 리스트 길이가 0 인지 확인합니다.")
    public void clear() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{1, 4, 5, 2, 4};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // when
        linkedList.clear();

        // then
        Assertions.assertEquals(linkedList.size(), 0);
    }

    @Test
    @DisplayName("첫번째 원소에 데이터가 추가되는지 확인합니다.")
    public void addFirst() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        linkedList.add(1);
        int expect = 10;

        // when
        linkedList.addFirst(expect);

        // then
        Assertions.assertEquals(linkedList.getFirst(), expect);
    }

    @Test
    @DisplayName("마지막 원소에 데이터가 추가되는지 확인합니다.")
    public void addLast() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        linkedList.add(1);
        int expect = 10;

        // when
        linkedList.addLast(expect);

        // then
        Assertions.assertEquals(linkedList.getLast(), expect);
    }

    @Test
    @DisplayName("특정 데이터의 첫 번째 인덱스 번호를 확인합니다.")
    public void indexOf() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));
        int expect = 1;

        // when
        int act = linkedList.indexOf(5);

        // then
        Assertions.assertEquals(expect, act);
    }

    @Test
    @DisplayName("특정 데이터의 마지막 인덱스 번호를 확인합니다.")
    public void lastIndexOf() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));
        int expect = 4;

        // when
        int act = linkedList.lastIndexOf(5);

        // then
        Assertions.assertEquals(expect, act);
    }

    @Test
    @DisplayName("특정 데이터가 존재하지 않으면 -1을 반환합니다.")
    public void assertIndexOfByNonExistsData() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));
        int expect = 4;

        // when
        int act = linkedList.lastIndexOf(100);

        // then
        Assertions.assertEquals(-1, act);
    }


    @Test
    @DisplayName("첫 번째 원소를 삭제합니다.")
    public void removeFirst() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // when
        int removeData = linkedList.remove();

        // then
        Assertions.assertEquals(testData[0], removeData);
        Assertions.assertEquals(testData.length - 1, linkedList.size());
    }

    @Test
    @DisplayName("특정 인덱스에 위치한 원소를 삭제합니다.")
    public void removeByIndex() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));
        int removeIndex = 4;
        int expectData = linkedList.get(removeIndex);

        // when
        int removeData = linkedList.remove(removeIndex);

        // then
        Assertions.assertEquals(expectData, removeData);
    }

    @Test
    @DisplayName("특정 데이터의 원소를 삭제합니다.")
    public void removeByElement() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));
        int removeIndex = rnd.nextInt(0, testData[testData.length - 1]);
        int removeData = linkedList.get(removeIndex);

        // when
        boolean isRemove = linkedList.remove((Integer) removeData);

        // then
        Assertions.assertTrue(isRemove);
    }

    @Test
    @DisplayName("인덱스 범위를 초과한 데이터를 삭제하면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertRemoveByIndexOutBound() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> linkedList.remove(-1),
            "인덱스 값은 배열 범위를 초과했습니다.");
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> linkedList.remove(linkedList.size()),
            "인덱스 값은 배열 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("특정 데이터가 존재하면 true를 반환합니다.")
    public void containsIsTrue() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // when
        boolean isContains = linkedList.contains(testData[rnd.nextInt(0, testData.length)]);

        // then
        Assertions.assertTrue(isContains);
    }

    @Test
    @DisplayName("특정 데이터가 존재하면 false를 반환합니다.")
    public void containsIsFalse() {
        // given
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        int[] testData = new int[]{10, 5, 1, 5, 5, 2, 4, 8};
        Arrays.stream(testData).forEach(e -> linkedList.add(e));

        // when
        boolean isContains = linkedList.contains(100);

        // then
        Assertions.assertFalse(isContains);
    }

}