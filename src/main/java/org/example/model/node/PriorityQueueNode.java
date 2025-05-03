package org.example.model.node;

public class PriorityQueueNode {

    private int value;
    private int priority;
    private PriorityQueueNode next;

    public PriorityQueueNode(int value, int priority, PriorityQueueNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityQueueNode getNext() {
        return next;
    }

    public void setNext(PriorityQueueNode next) {
        this.next = next;
    }
}
