package com.dataStructure.collections.arrayList;


import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MyListImplTest {

    Random rnd = new Random();

    @Test
    @DisplayName("List 초기화 시, size 0을 확인합니다.")
    public void assertInit() {
        // given
        MyList<Integer> list = new MyListImpl<>();

        // when

        // then
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    @DisplayName("clear 후 리스트 빈 값 여부를 확인합니다.")
    public void assertClear() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        list.add(rnd.nextInt(1, 10));

        // when
        list.clear();

        // then
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("5번 반복했을 때 모두 일치하는지 확인합니다.")
    public void assertAdd() {
        // given
        MyList<Integer> list = new MyListImpl<>();

        // when
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }

        // then
        for (int i = 1; i < 5; i++) {
            Assertions.assertEquals(list.get(i - 1), i);
        }
    }

    @Test
    public void addTest() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(e));
        int insertIdx = rnd.nextInt(1, 10);
        int insertValue = rnd.nextInt(1, 10);

        // when
        list.add(insertIdx, insertValue);

        // then
        Assertions.assertEquals(list.get(insertIdx), insertValue);

    }

    @Test
    @DisplayName("DEFAULT_SIZE 길이를 넘겼을 때 정상적으로 리스트 사이즈가 1 증가하는 지 확인합니다.")
    public void validateListSize() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int defaultSize = 10;
        IntStream.rangeClosed(1, defaultSize).forEach(e -> list.add(e));

        // when
        list.add(rnd.nextInt(1, 10));

        // then
        Assertions.assertEquals(list.size(), 11);
    }

    @Test
    @DisplayName("n번 리스트 삽입 시, size() 값을 확인합니다.")
    public void assertSize() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int count = rnd.nextInt(2, 10);

        // when
        IntStream.rangeClosed(1, count).forEach(e -> list.add(e));

        // then
        Assertions.assertEquals(count, list.size());
    }

    @Test
    @DisplayName("특정 값이 리스트에 존재하면 true를 반환합니다.")
    public void assertContainsBySuccess() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(e));

        // when

        // then
        Assertions.assertTrue(list.contains(rnd.nextInt(1, 10)));
    }

    @Test
    @DisplayName("특정 값이 리스트에 존재하지 않으면 false를 반환합니다.")
    public void assertContainsByFail() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(e));

        // when

        // then
        Assertions.assertFalse(list.contains(11));
    }

    @Test
    @DisplayName("index 범위를 벗어나면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertGetByIndexBounded() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt();
        list.add(data);

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.get(list.size()), "범위를 초과했습니다.");
    }

    @Test
    @DisplayName("index가 0보다 작으면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertGetByNonNegative() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt();
        list.add(data);

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.get(-1), "범위를 초과했습니다.");
    }

    @Test
    @DisplayName("index값으로 삭제한 데이터를 검증합니다.")
    public void assertRemove() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int expect = list.get(3);

        // when
        Integer actual = list.remove(3);

        // then
        Assertions.assertEquals(expect, actual);
    }

    @Test
    @DisplayName("존재하지 않는 Object를 삭제하면 false를 반환합니다.")
    public void assertRemoveByFail() {
        // given
        MyList<String> list = new MyListImpl<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString());
        }

        // when
        boolean result = list.remove("hello");

        // then
        Assertions.assertFalse(result);
        Assertions.assertEquals(10, list.size());
    }

    @Test
    @DisplayName("존재하는 Object를 삭제하면 true를 반환합니다.")
    public void assertRemoveBySuccess() {
        // given
        MyList<String> list = new MyListImpl<>();
        for (int i = 0; i < 10; i++) {
            list.add(UUID.randomUUID().toString());
        }

        // when
        boolean result = list.remove(list.get(0));

        // then
        Assertions.assertTrue(result);
        Assertions.assertEquals(9, list.size());
    }

    @Test
    @DisplayName("index 값이 size 보다 크면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertRemoveByMaxLength() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt();
        list.add(data);

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.remove(list.size()), "범위를 초과했습니다.");
    }

    @Test
    @DisplayName("index 값이 0보다 작으면 ArrayIndexOutOfBoundsException 예외를 던집니다.")
    public void assertRemoveByIndexNonNegative() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt();
        list.add(data);

        // when

        // then
        Assertions.assertThrowsExactly(ArrayIndexOutOfBoundsException.class,
            () -> list.remove(-1), "범위를 초과했습니다.");
    }

    @Test
    @DisplayName("특정 데이터의 index 값을 검증합니다.")
    public void assertIndexOfSuccess() {
        // given
        MyList<String> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(UUID.randomUUID().toString()));

        // when

        // then
        int index = rnd.nextInt(1, 10);
        String assertData = list.get(index);
        Assertions.assertEquals(list.indexOf(assertData), index);
    }

    @Test
    @DisplayName("존재하지 않는 데이터 인덱스를 조회하면 -1을 반환한다.")
    public void assertIndexOfFail() {
        // given
        MyList<String> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(UUID.randomUUID().toString()));

        // when

        // then
        Assertions.assertEquals(-1, list.indexOf("아무 데이터나 넣어"));
    }

    @Test
    @DisplayName("마지막 데이터가 일치하면 1을 반환한다.")
    public void assertLastIndexOfSuccess() {
        // given
        MyList<String> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(UUID.randomUUID().toString()));

        // when

        // then
        String assertData = list.get(9);
        Assertions.assertEquals(list.lastIndexOf(assertData), 1);
    }

    @Test
    @DisplayName("마지막 데이터가 불일치하면 -1을 반환한다.")
    public void assertLastIndexOfFail() {
        // given
        MyList<String> list = new MyListImpl<>();
        IntStream.rangeClosed(1, 10).forEach(e -> list.add(UUID.randomUUID().toString()));

        // when

        // then
        Assertions.assertEquals(list.lastIndexOf("아무데이터나넣어"), -1);
    }
}