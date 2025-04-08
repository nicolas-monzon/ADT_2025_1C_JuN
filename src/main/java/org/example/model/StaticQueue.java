package org.example.model;

public class StaticQueue implements Queue{

    private static final int MAX = 10000;
    private int[] array;
    private int count;

    public StaticQueue() {
        array = new int[MAX];
        count = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Queue is full");
        }

        if(this.isEmpty()) {
            array[0] = a;
            count++;
            return;
        }

        // [1, 2, 3, 0, 0, 0, 0, 0, ...
        // [1, 2, 3, 3, 0, 0, 0, 0, ...
        // [1, 2, 2, 3, 0, 0, 0, 0, ...
        // [?, 1, 2, 3, 0, 0, 0, 0, ...

        for(int i = count; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = a;
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return array[count-1];
    }
}
