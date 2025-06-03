package org.example.util;

import org.example.model.Queue;
import org.example.model.Stack;
import org.example.model.StaticQueue;
import org.example.model.StaticStack;

public class QueueUtil {

    // 1. queue -> aux & result, 2. aux -> queue
    // 1. queue -> aux, 2. aux -> queue & result
    public static Queue copy(Queue queue) {
        Queue result = new StaticQueue();
        Queue aux = new StaticQueue();

        while (!queue.isEmpty()) {
            int first = queue.getFirst();
            aux.add(first);
            result.add(first);
            queue.remove();
        }

        while (!aux.isEmpty()) {
            int first = aux.getFirst();
            queue.add(first);
            aux.remove();
        }

        return result;
    }

    public static void print(Queue queue) {
        Queue copy = copy(queue);
        String result = "";
        while (!copy.isEmpty()) {
            int first = copy.getFirst();
            result = first + "\t" + result;
            copy.remove();
        }
        if (!result.isEmpty()) {
            System.out.println(result.substring(0, result.length() - 1));
        }
        System.out.println();
    }

    public static void reverse(Queue queue) {
        Stack stack = new StaticStack();

        while (!queue.isEmpty()) {
            stack.add(queue.getFirst());
            queue.remove();
        }

        while (!stack.isEmpty()) {
            queue.add(stack.getTop());
            stack.remove();
        }
    }

    public static void reverse2(Queue queue) {
        if (queue.isEmpty()) {
            return;
        }
        int first = queue.getFirst();
        queue.remove();
        reverse2(queue);
        queue.add(first);
    }

    // q1: 1, 2, 3, 4
    // q2: 6 5
    // q3: -

    public static void reverse3(Queue queue) {
        if (queue == null) {
            return;
        }
        Queue result = new StaticQueue();
        Queue aux = new StaticQueue();

        if (queue.isEmpty()) {
            return;
        }

        while (!queue.isEmpty()) {
            int first = queue.getFirst();

            aux.add(first);
            while (!result.isEmpty()) {
                aux.add(result.getFirst());
                result.remove();
            }

            while (!aux.isEmpty()) {
                result.add(aux.getFirst());
                aux.remove();
            }

            queue.remove();
        }

        while (!result.isEmpty()) {
            queue.add(result.getFirst());
            result.remove();
        }
    }

    public static void reverse4(Queue queue) {
        Queue result = new StaticQueue();

        while (!queue.isEmpty()) {
            int last = getLast(queue);
            result.add(last);
            removeLast(queue);
        }

        while (!result.isEmpty()) {
            queue.add(result.getFirst());
            result.remove();
        }
    }

    // TODO Tiene un bug
    private static void removeLast(Queue queue) {
        Queue aux = new StaticQueue();
        while (!queue.isEmpty()) {
            int first = queue.getFirst();
            queue.remove();
            if (queue.isEmpty()) {
                break;
            }
            aux.add(first);
        }

        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            aux.remove();
        }
    }

    private static int getLast(Queue queue) {
        if (queue == null || queue.isEmpty()) {
            throw new RuntimeException("No hay elementos, entonces no existe un último elemeto");
        }

        int first = queue.getFirst();
        queue.remove();
        if (queue.isEmpty()) {
            queue.add(first);
            return first;
        }

        int result = getLast(queue);
        queue.add(first);
        return result;
    }

}
