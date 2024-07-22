package com.dataStructure;

public class QueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Long> list = new LinkedListQueue<>();
        System.out.println("빈 리스트가 출력되어야 한다");
        System.out.println(list.toString());
        System.out.println();

//        System.out.println("list는 비어있어야 한다");
//        System.out.println("list.isEmpty() = " + list.isEmpty());
//        System.out.println();

        System.out.println("list는 1, 2, 3, 4를 포함해야 한다");
        list.offer(1L);
        list.offer(2L);
        list.offer(3L);
        list.offer(4L);
        System.out.println("list = " + list.toString());
        System.out.println();

//        System.out.println("list는 비어있지 않아야 한다");
//        System.out.println("list.isEmpty() = " + list.isEmpty());
//        System.out.println();


        System.out.println("가장 먼저 들어온 값이 삭제되어야 한다");
        list.poll();
        System.out.println("list = " + list.toString());
        System.out.println();

        System.out.println("list의 크기는 3이어야 한다");
        System.out.println("list.size() = " + list.size());
        System.out.println();

//        System.out.println("list는 3, 4를 포함해야 한다");
//        list.remove();
//        System.out.println("list = " + list.toString());
//        System.out.println();

//        System.out.println("list는 3을 포함해야 한다");
//        boolean contain3 = list.contains(3L);
//        System.out.println("contain3 = " + contain3);
//        System.out.println();

//        System.out.println("10은 없으므로 false을 반환해야 한다");
//        boolean contain10 = list.contains(10L);
//        System.out.println("contain10 = " + contain10);


        System.out.println("peek를 하면 가장 먼저 들어온 값을 가져와야한다");
        Long peek = list.peek();
        System.out.println("peek = " + peek);
        System.out.println();

//        System.out.println("clear를 하면 list는 비어있어야 한다");
//        list.clear();
//        System.out.println("list.isEmpty() = " + list.isEmpty());
//        System.out.println();


    }
}
