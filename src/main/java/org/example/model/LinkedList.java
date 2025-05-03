package org.example.model;

import org.example.model.node.Node;

public class LinkedList implements List {

    private Node node;

    @Override
    public void add(int a) {
        if(node == null) {
            node = new Node(a, null);
            return;
        }

        Node candidate = node;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new Node(a, null));
    }

    @Override
    public void remove() {
        if(node == null) {
            throw new RuntimeException("List is empty");
        }

        if(node.getNext() == null) {
            node = null;
            return;
        }

        Node previous = node;
        Node current = node.getNext();

        while(current.getNext() != null) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(null);
    }

    @Override
    public int size() {
        if(node == null) {
            return 0;
        }
        int size = 0;

        Node current = node;
        while(current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }

    @Override
    public int get(int index) {
        if(node == null) {
            throw new RuntimeException("List is empty");
        }
        if(index < 0) {
            throw new RuntimeException("Index is negative");
        }

        int count = 0;
        Node current = node;
        while(current != null) {
            if(count == index) {
                return current.getValue();
            }
            count++;
            current = current.getNext();
        }

        throw new RuntimeException("Index is out of range");
    }
}
