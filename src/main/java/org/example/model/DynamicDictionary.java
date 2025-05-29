package org.example.model;

import org.example.model.node.KeyNode;
import org.example.model.node.ValueNode;

public class DynamicDictionary implements Dictionary {

    private KeyNode node;

    @Override
    public void add(int k, int v) {
        if(node == null) {
            node = new KeyNode(k, null, new ValueNode(v, null));
            return;
        }

        KeyNode candidate = node;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == k) {
                throw new RuntimeException("La clave ya exista");
            }
            candidate = candidate.getNext();
        }

        if(candidate.getKey() == k) {
            throw new RuntimeException("La clave ya exista");
        }
        candidate.setNext(new KeyNode(k, null, new ValueNode(v, null)));
    }

    @Override
    public void remove(int k, int v) {
        if(node == null) {
            return;
        }

        if(node.getNext() == null) {
            if(node.getKey() == k) {
                node = null;
            }
            return;
        }

        KeyNode previous = node;
        KeyNode current = node.getNext();

        while(current.getNext() != null) {
            if(current.getKey() == k) {
                previous.setNext(current.getNext());
                return;
            }
            previous = current;
            current = current.getNext();
        }

        if(current.getKey() == k) {
            previous.setNext(current.getNext());
        }
    }

    @Override
    public Set getKeys() {
        Set keys = new DynamicSet();
        KeyNode current = node;
        while(current != null) {
            keys.add(current.getKey());
            current = current.getNext();
        }
        return keys;
    }

    @Override
    public int getValue(int k) {
        KeyNode current = node;
        while(current != null) {
            if(current.getKey() == k) {
                return current.getValues().getValue();
            }
            current = current.getNext();
        }
        throw new RuntimeException("No se encontró la clave");
    }
}
