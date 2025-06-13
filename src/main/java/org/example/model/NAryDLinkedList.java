package org.example.model;

import org.example.model.node.NAryDLinkedListNode;

public class NAryDLinkedList implements NAryTreeList {

    NAryDLinkedListNode node;

    @Override
    public void add(NAryTree a) {
        if (node == null) {
            node = new NAryDLinkedListNode(a, null, null);
            return;
        }

        NAryDLinkedListNode candidate = node;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new NAryDLinkedListNode(a, null, candidate));
    }

    @Override
    public void remove() {
        if (node == null) {
            throw new RuntimeException("List is empty");
        }

        if (node.getNext() == null) {
            node = null;
            return;
        }

        NAryDLinkedListNode current = node;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.getPrev().setNext(null);
    }

    @Override
    public int size() {
        if (node == null) {
            return 0;
        }
        int size = 0;

        NAryDLinkedListNode current = node;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }

    @Override
    public NAryTree get(int index) {
        if (node == null) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0) {
            throw new RuntimeException("Index is negative");
        }

        int count = 0;
        NAryDLinkedListNode current = node;
        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            count++;
            current = current.getNext();
        }

        throw new RuntimeException("Index is out of range");
    }
}
