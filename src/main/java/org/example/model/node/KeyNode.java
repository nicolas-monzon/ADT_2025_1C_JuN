package org.example.model.node;

public class KeyNode {

    private int key;
    private KeyNode next;
    private ValueNode values;

    public KeyNode(int key, KeyNode next, ValueNode value) {
        this.key = key;
        this.next = next;
        this.values = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }

    public ValueNode getValues() {
        return values;
    }

    public void setValues(ValueNode values) {
        this.values = values;
    }
}
