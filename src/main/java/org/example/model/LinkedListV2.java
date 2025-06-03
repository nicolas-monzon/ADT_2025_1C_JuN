package org.example.model;

import org.example.model.node.Node;

public class LinkedListV2 implements List {

    private Node node;
    private Node last;
    private int size;

    @Override
    public void add(int a) {
        if (node == null) {
            node = new Node(a, null);
            last = node;
            size++;
            return;
        }

        Node newNode = new Node(a, null);
        last.setNext(newNode);
        last = newNode;
        size++;
    }

    @Override
    public void remove() {
        if (node == null) {
            throw new RuntimeException("List is empty");
        }

        if (node.getNext() == null) {
            node = null;
            last = null;
            size--;
            return;
        }

        Node previous = node;
        Node current = node.getNext();

        while (current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(null);
        last = previous;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (node == null) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index is negative");
        }

        int count = 0;
        Node current = node;
        while (current.getNext() != null) {
            if (count == index) {
                return current.getValue();
            }
            count++;
            current = current.getNext();
        }
        return current.getValue();
    }
}
