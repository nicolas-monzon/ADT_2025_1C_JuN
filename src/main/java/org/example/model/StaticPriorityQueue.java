package org.example.model;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int MAX_VALUE = 10000;

    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        this.values = new int[MAX_VALUE];
        this.priorities = new int[MAX_VALUE];
        this.count = 0;
    }

    @Override
    public void add(int value, int priority) {
        if(this.isEmpty()) {
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        if(count == MAX_VALUE) {
            throw new IllegalStateException("Priority queue is full");
        }

        if(priority < priorities[0]) {
            for(int i = count; i >= 1; i--) {
                this.values[i] = this.values[i-1];
                this.priorities[i] = this.priorities[i-1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        if(priority >= priorities[count-1]) {
            this.values[count] = value;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        int index = 0;
        for( ;index < count; index++) {
            if(this.priorities[index] > priority) {
                break;
            }
        }

        for(int i = count; i >= index + 1; i--) {
            this.values[i] = this.values[i-1];
            this.priorities[i] = this.priorities[i-1];
        }

        this.values[index] = value;
        this.priorities[index] = priority;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        for(int i = 0; i < this.count - 1; i++) {
            this.values[i] = this.values[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return this.values[0];
    }

    @Override
    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad del primero de una cola vacía");
        }
        return this.priorities[0];
    }
}
