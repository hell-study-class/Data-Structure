package com.dataStructure;

public class StackTest {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        stack.push("a");
        stack.push("b");
        System.out.println("a,b가 있어야 한다");
        System.out.println(stack.toString());

        System.out.println("Stack이 비어있지 않아야 한다");
        System.out.println(stack.empty());

        stack.pop();
        System.out.println("b가 없어야 한다");
        System.out.println(stack.toString());

        stack.push("c");
        stack.push("d");
        System.out.println("d를 반환해야 한다.");
        System.out.println(stack.toString());
        System.out.println("return: " + stack.peek());

        System.out.println("index=0 반환해야 한다.");
        System.out.println(stack.search("c"));

    }
}
