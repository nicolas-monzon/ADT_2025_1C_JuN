package org.example.model;

public class StaticStack implements Stack {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Stack overflow");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        count--;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
