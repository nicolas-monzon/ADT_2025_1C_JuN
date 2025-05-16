package org.example.util;

import org.example.model.PriorityQueue;
import org.example.model.StaticPriorityQueue;

public class PriorityQueueUtil {

    private PriorityQueueUtil() {

    }

    public static PriorityQueue copy(PriorityQueue priorityQueue) {
        PriorityQueue copy = new StaticPriorityQueue();
        PriorityQueue aux = new StaticPriorityQueue();

        while(!priorityQueue.isEmpty()) {
            copy.add(priorityQueue.getFirst(), priorityQueue.getPriority());
            aux.add(priorityQueue.getFirst(), priorityQueue.getPriority());
            priorityQueue.remove();
        }

        while(!aux.isEmpty()) {
            priorityQueue.add(aux.getFirst(), aux.getPriority());
            aux.remove();
        }

        return copy;
    }

}
