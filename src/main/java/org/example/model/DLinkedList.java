package org.example.model;

import org.example.model.node.DLinkedListNode;

public class DLinkedList implements List {

    DLinkedListNode node;

    @Override
    public void add(int a) {
        if(node == null) {
            node = new DLinkedListNode(a, null, null);
            return;
        }

        DLinkedListNode candidate = node;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new DLinkedListNode(a, null, candidate));
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

        DLinkedListNode current = node;

        while(current.getNext() != null) {
            current = current.getNext();
        }

        current.getPrev().setNext(null);
    }

    @Override
    public int size() {
        if(node == null) {
            return 0;
        }
        int size = 0;

        DLinkedListNode current = node;
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
        DLinkedListNode current = node;
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
