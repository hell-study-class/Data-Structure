package com.dataStructure.arraylist;

public class MyArrayListExample {
    public static void main(String[] args) {
        MyList<Long> list = new MyArrayList<>();
        System.out.println("빈 리스트가 출력되어야 한다");
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list는 비어있어야 한다");
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println();

        System.out.println("list는 1, 2, 3, 4를 포함해야 한다");
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list는 비어있지 않아야 한다");
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println();

        System.out.println("0번 인덱스에 5가 추가되어야 한다");
        list.add(0, 5L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("2번 인덱스에 6이 추가되어야 한다");
        list.add(2, 6L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("값 2가 삭제되어야 한다");
        list.remove(2L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list의 크기는 5이어야 한다");
        System.out.println("list.size() = " + list.size());
        System.out.println();

        System.out.println("list는 5, 6, 3, 4를 포함해야 한다");
        list.remove(1);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("2번 인덱스의 값이 11로 변경되어야 한다");
        list.set(2, 11L);
        System.out.println("list = " + list);
        System.out.println();

        System.out.println("list는 6을 포함해야 한다");
        boolean contain6 = list.contains(6L);
        System.out.println("contain6 = " + contain6);
        System.out.println();

        System.out.println("10은 없으므로 false을 반환해야 한다");
        boolean contain10 = list.contains(10L);
        System.out.println("contain10 = " + contain10);
        System.out.println();

        System.out.println("6의 index를 확인하면 1이어야 한다");
        int index6 = list.indexOf(6L);
        System.out.println("index6 = " + index6);
        System.out.println();

        System.out.println("6의 index를 뒤에서부터 확인하면 1이어야 한다");
        int lastIndex6 = list.lastIndexOf(6L);
        System.out.println("lastIndex6 = " + lastIndex6);
        System.out.println();

        System.out.println("clear를 하면 list는 비어있어야 한다");
        list.clear();
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println();
    }
}
