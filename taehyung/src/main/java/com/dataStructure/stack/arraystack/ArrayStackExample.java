package com.dataStructure.stack.arraystack;

public class ArrayStackExample {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);

        stack.push(4);
        stack.push(5);
        System.out.println("stack = " + stack);

        stack.push(6);
        stack.push(7);
        System.out.println("stack = " + stack);

        System.out.println("stack.peek() = " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("stack = " + stack);
    }
}
