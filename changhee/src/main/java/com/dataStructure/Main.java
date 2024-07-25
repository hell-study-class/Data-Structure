package com.dataStructure;

import com.dataStructure.collections.arrayDeque.MyArrayDeque;
import com.dataStructure.collections.arrayList.ArrayList;
import com.dataStructure.collections.arrayList.MyList;
import com.dataStructure.collections.circularSinglyLinkedList.CircularSinglyLinkedList;
import com.dataStructure.collections.linkedList.MyDoublyLinkedList;
import com.dataStructure.collections.linkedList.MySingleLinkedList;
import com.dataStructure.collections.linkedQueue.MyLinkedQueue;

public class Main {
    public static void main(String[] args) {
        MyLinkedQueue<Long> list = new MyLinkedQueue<>();
        System.out.println("빈 리스트가 출력되어야 한다");
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list는 1, 2, 3, 4를 포함해야 한다");
        list.offer(1L);
        list.offer(2L);
        list.offer(3L);
        list.offer(4L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("값 1가 삭제되어야 한다");
        System.out.println("삭제 된 값 : "+list.poll());
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list의 크기는 3이어야 한다");
        System.out.println("list.size() = " + list.size());
        System.out.println();

        System.out.println("list 첫 번째 값인 2가 나와야한다.");
        System.out.println("list.peek() = " + list.peek());
        System.out.println();

        System.out.println("clear를 하면 list는 비어있어야 한다");
        list.clear();
        System.out.println("list = " + list);
        System.out.println();
    }
}