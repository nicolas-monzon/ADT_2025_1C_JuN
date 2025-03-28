package org.example;

import org.example.model.Stack;
import org.example.model.StaticStack;
import org.example.util.StackUtil;

public class App {

    public static void main(String[] args) {
        Stack stack = new StaticStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.remove();
        System.out.println(stack.getTop());
        StackUtil.copy(stack);
    }
}