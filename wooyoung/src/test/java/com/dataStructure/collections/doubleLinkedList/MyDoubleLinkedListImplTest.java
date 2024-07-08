package com.dataStructure.collections.doubleLinkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyDoubleLinkedListImplTest {

    Random rnd = new Random();

    @Test
    @DisplayName("랜덤의 데이터를 add하고 확인합니다.")
    public void assertAddByRandomData() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int n1 = rnd.nextInt(1, 10);
        int n2 = rnd.nextInt(1, 10);
        int n3 = rnd.nextInt(1, 10);

        // when
        list.add(n1);
        list.add(n2);
        list.add(n3);

        // then
        Assertions.assertEquals(list.get(0), n1);
        Assertions.assertEquals(list.get(1), n2);
        Assertions.assertEquals(list.get(2), n3);
    }

    @Test
    @DisplayName("0 미만 리스트 사이즈보다 큰 인덱스 값으로 조회하면 예외를 던집니다.")
    public void assertAddByOutBoundIndex() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int[] datas = new int[]{0, 1, 2, 3, 4, 5};
        Arrays.stream(datas).forEach(i -> list.add(datas[i]));

        // when

        // then
        Assertions.assertThrowsExactly(NoSuchElementException.class,
            () -> list.get(list.size()), "인덱스 값은 배열 범위를 초과했습니다.");
    }

    @Test
    @DisplayName("clear 호출 시 정상적으로 리스트가 초기화 되는지 확인합니다.")
    public void assertClear() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int[] datas = new int[]{0, 1, 2, 3, 4, 5};
        Arrays.stream(datas).forEach(i -> list.add(datas[i]));

        // when
        list.clear();

        // then
        Assertions.assertEquals(list.size(), 0);
    }


    @Test
    @DisplayName("0번째 인덱스에 대하여 add(index) 메서드를 테스트합니다.")
    public void assertAddToFirstIndex() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = rnd.nextInt(1, 10);
        int num2 = rnd.nextInt(1, 10);
        list.add(num1);

        // when
        list.add(0, num2);

        // then
        Assertions.assertEquals(list.get(0), num2);
        Assertions.assertEquals(list.get(1), num1);
    }

    @Test
    @DisplayName("마지막 인덱스에 대하여 add(index) 메서드를 테스트합니다.")
    public void assertAddToLastIndex() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = rnd.nextInt(1, 10);
        int num2 = rnd.nextInt(1, 10);
        int num3 = rnd.nextInt(1, 10);
        list.add(num1);
        list.add(num2);

        // when
        list.add(1, num3);

        // then
        Assertions.assertEquals(list.get(0), num1);
        Assertions.assertEquals(list.get(1), num2);
        Assertions.assertEquals(list.get(2), num3);
    }

    @Test
    @DisplayName("인덱스 값이 리스트 범위를 벗어나면 예외를 던집니다.")
    public void assertAddByIndexOutBound() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = rnd.nextInt(1, 10);
        int num2 = rnd.nextInt(1, 10);

        // when

        // then
        Assertions.assertThrowsExactly(NoSuchElementException.class,
            () -> list.add(100, 10));
    }

    @Test
    @DisplayName("마지막 원소의 포함 여부를 확인합니다.")
    public void assertContainsLastData() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = rnd.nextInt(1, 10);
        int num2 = rnd.nextInt(1, 10);
        list.add(num1);
        list.add(num2);

        // then
        boolean isContains = list.contains(num2);

        // then
        Assertions.assertTrue(isContains);
    }

    @Test
    @DisplayName("첫 번째 원소의 포함 여부를 확인합니다.")
    public void assertContainsFirstData() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = rnd.nextInt(1, 10);
        int num2 = rnd.nextInt(1, 10);
        list.add(num1);
        list.add(num2);

        // then
        boolean isContains = list.contains(num1);

        // then
        Assertions.assertTrue(isContains);
    }

    @Test
    @DisplayName("중복된 데이터 경우 첫번째 원소의 인덱스를 반환합니다.")
    public void assertIndexOfByDuplicate() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = 3;
        int num2 = 5;
        int num3 = 5;
        list.add(num1);
        list.add(num2);
        list.add(num3);

        // then
        int findIndex = list.indexOf(num2);

        // then
        Assertions.assertEquals(findIndex, 1);
    }

    @Test
    @DisplayName("중복된 데이터 경우 첫번째 원소의 인덱스를 반환합니다.")
    public void assertLastIndexOfByDuplicate() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        int num1 = 5;
        int num2 = 3;
        int num3 = 5;
        list.add(num1);
        list.add(num2);
        list.add(num3);

        // then
        int findIndex = list.lastIndexOf(num1);

        // then
        Assertions.assertEquals(findIndex, 2);
    }

    @Test
    @DisplayName("빈 리스트의 경우 remove 메서드를 호출하면 예외를 던집니다.")
    public void assertRemoveNoData() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();

        // when

        // then
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> list.remove(0));
        Assertions.assertThrowsExactly(NoSuchElementException.class,
            () -> list.remove((Integer) 10));
    }

    @Test
    @DisplayName("첫 번째 원소를 삭제합니다.")
    public void remove() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        int removeData = list.remove(0);

        Assertions.assertEquals(removeData, 1);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    @DisplayName("길이가 1일 때 특정 원소를 삭제합니다.")
    public void assertRemoveObjectBySizeIs1() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        list.add(1);

        // when
        boolean isRemove = list.remove((Integer) 1);

        // then
        Assertions.assertTrue(isRemove);
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("특정 원소가 마지막 인덱스 위치할 때 데이터를 삭제합니다.")
    public void assertRemoveObjectByLastIndex() {
        // given
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        boolean isRemove = list.remove((Integer) 3);

        // then
        Assertions.assertTrue(isRemove);
        Assertions.assertEquals(list.size(), 2);
    }
}