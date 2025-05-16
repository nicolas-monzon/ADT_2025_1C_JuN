package org.example.model;

import org.example.model.node.Node;

import java.util.Random;

public class DynamicSet implements Set {

    private Node node;
    private int size;
    private Random random;

    public DynamicSet() {
        this.random = new Random();
    }

    @Override
    public void add(int a) {
        if(isEmpty()) {
            node = new Node(a, null);
            size++;
            return;
        }

        Node current = this.node;
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }
        if(current.getValue() == a) {
            return;
        }
        current.setNext(new Node(a, null));
        size++;
    }

    @Override
    public void remove(int a) {
        if(isEmpty()) {
            return;
        }

        if(this.node.getNext() == null) {
            if(this.node.getValue() == a) {
                this.node = null;
                size--;
            }
            return;
        }

        Node previous = node;
        Node current = node.getNext();

        while(current.getNext() != null) {
            if(current.getValue() == a) {
                previous.setNext(current.getNext());
                size--;
                return;
            }

            previous = current;
            current = current.getNext();
        }

        if(current.getValue() == a) {
            previous.setNext(current.getNext());
            size--;
        }
    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir de un conjunto vacío");
        }
        int randomIndex = random.nextInt(size);

        Node current = this.node;
        int i = 0;
        while(current != null) {
            if(i == randomIndex) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }

        throw new RuntimeException("Generic error");
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }
}
