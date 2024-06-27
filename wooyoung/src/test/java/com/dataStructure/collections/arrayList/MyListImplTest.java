package com.dataStructure.collections.arrayList;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyListImplTest {

    Random rnd = new Random();

    @Test
    @DisplayName("add 테스트")
    public void add() {
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
    @DisplayName("addAll 테스트")
    public void addAll() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt(1, 10);

        // when

        list.add(data);

        // then
        Assertions.assertEquals(list.get(0), data);
    }

    @Test
    @DisplayName("리스트 범위의 값을 조회하면 ArrayIndexOutOfBoundsException 예외를 던진다.")
    public void assertIndexBoundExceptionByAdd() {
        // given
        MyList<Integer> list = new MyListImpl<>();
        int data = rnd.nextInt();
        list.add(data);

        // when
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(list.size()));

        // then
    }

//    @Test
//    public void remove() {
//        // given
//        MyList<Integer> list = new MyListImpl<>();
//        int size = 10;
//        for (int i = 1; i < size; i++) {
//            list.add(i);
//        }
//
//        // when
//        list.remove(3);
//
//        // then
//        System.out.println(list.size());
//    }

}