package org.example.model;

public class List<T> {

    private boolean empty;
    private T head;
    private List<T> tail;

    public List() {

    }

    public List(T head, List tail) {
        this.head = head;
        this.tail = tail;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public T getHead() {
        return head;
    }

    public void setHead(T head) {
        this.head = head;
    }

    public List<T> getTail() {
        return tail;
    }

    public void setTail(List<T> tail) {
        this.tail = tail;
    }
}
