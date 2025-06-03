package org.example.model;

public interface PriorityQueue {

    void add(int value, int priority);

    void remove();

    boolean isEmpty();

    int getFirst();

    int getPriority();

}
