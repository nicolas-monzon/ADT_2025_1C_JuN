package org.example.util;

import org.example.model.Stack;
import org.example.model.StaticStack;

public class StackUtil {

    private StackUtil() {

    }

    public static Stack copy(Stack stack) {
        Stack copy = new StaticStack();
        Stack aux = new StaticStack();

        while (!stack.isEmpty()) {
            int top = stack.getTop();
            aux.add(top);
            stack.remove();
        }

        while (!aux.isEmpty()) {
            int top = aux.getTop();
            copy.add(top);
            stack.add(top);
            aux.remove();
        }

        return copy;
    }

    public static void print(Stack stack) {
        Stack aux = copy(stack);
        while (!aux.isEmpty()) {
            System.out.println(aux.getTop());
            aux.remove();
        }
    }

    public static int size(Stack stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int top = stack.getTop();
        stack.remove();
        int aux = size(stack);
        stack.add(top);
        return 1 + aux;
    }

    public static void reverse(Stack stack) {
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();

        while (!stack.isEmpty()) {
            int top = stack.getTop();
            aux.add(top);
            stack.remove();
        }

        while (!aux.isEmpty()) {
            int top = aux.getTop();
            aux2.add(top);
            aux.remove();
        }

        while (!aux2.isEmpty()) {
            int top = aux2.getTop();
            stack.add(top);
            aux2.remove();
        }
    }

    public static Stack sort(Stack stack) {
        Stack copy = copy(stack);
        sort(copy);
        return copy;
    }

    public static void sortAux(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.getTop();
        stack.remove();
        if (stack.isEmpty()) {
            stack.add(top);
            return;
        }

        int total = size(stack) - 1;
        for (int i = 0; i < total; i++) {
            move(stack);
        }
    }

    public static boolean cap(Stack stack) {
        Stack copy = copy(stack);
        Stack aux = copy(stack);
        reverse(copy);
        return equalsAux(stack, aux);
    }

    private static boolean equalsAux(Stack stack, Stack stack2) {
        while (!stack.isEmpty()) {
            if (stack.getTop() != stack2.getTop()) {
                return false;
            }
            stack.remove();
            stack2.remove();
        }
        return true;
    }

    public static void move(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.getTop();
        stack.remove();
        if (stack.isEmpty()) {
            stack.add(top);
            return;
        }

        int next = stack.getTop();
        stack.remove();

        if (top > next) {
            stack.add(top);
            move(stack);
        }

        stack.add(next);
    }

}
