package org.example;

import org.example.model.Queue;
import org.example.model.StaticQueue;
import org.example.util.QueueUtil;

public class Main { // Manim
    public static void main(String[] args) {
        Queue queue = new StaticQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        QueueUtil.print(queue);
        QueueUtil.reverse4(queue);
        QueueUtil.print(queue);
    }
}