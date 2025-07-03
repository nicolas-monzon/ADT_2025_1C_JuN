package org.example.model;

import org.example.model.node.PriorityQueueNode;

public class DynamicPriorityQueue implements PriorityQueue {

    private PriorityQueueNode first;

    @Override
    public void add(int value, int priority) {
        if (this.isEmpty()) {
            first = new PriorityQueueNode(value, priority, null);
            return;
        }

        if (priority < first.getPriority()) {
            first = new PriorityQueueNode(value, priority, first);
            return;
        }

        PriorityQueueNode current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        if (priority >= current.getPriority()) {
            current.setNext(new PriorityQueueNode(value, priority, null));
            return;
        }

        if (this.first.getNext() == null) { // Solo para que el compilador no tire una advertencia
            return;
        }

        PriorityQueueNode prev = current;
        current = current.getNext();

        while (current.getNext() != null) {
            if (current.getPriority() > priority) {
                prev.setNext(new PriorityQueueNode(value, priority, current));
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        first = first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public int getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return this.first.getValue();
    }

    @Override
    public int getPriority() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad del primero de una cola vacía");
        }
        return this.first.getPriority();
    }
}
