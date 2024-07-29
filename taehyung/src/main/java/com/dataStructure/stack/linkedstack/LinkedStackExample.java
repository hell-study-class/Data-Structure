package com.dataStructure.stack.linkedstack;

public class LinkedStackExample {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        System.out.println("stack.empty() = " + stack.empty());
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            System.out.println("stack.peek() = " + stack.peek());
        }
        System.out.println("stack.empty() = " + stack.empty());
        for (int i = 0; i < 5; i++) {
            System.out.println("stack.pop() = " + stack.pop());
        }
    }
}
