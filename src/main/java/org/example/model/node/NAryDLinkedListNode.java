package org.example.model.node;

import org.example.model.NAryTree;

public class NAryDLinkedListNode {

    private NAryTree value;
    private NAryDLinkedListNode next;
    private NAryDLinkedListNode prev;

    public NAryDLinkedListNode(NAryTree value, NAryDLinkedListNode next, NAryDLinkedListNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public NAryTree getValue() {
        return value;
    }

    public void setValue(NAryTree value) {
        this.value = value;
    }

    public NAryDLinkedListNode getNext() {
        return next;
    }

    public void setNext(NAryDLinkedListNode next) {
        this.next = next;
    }

    public NAryDLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(NAryDLinkedListNode prev) {
        this.prev = prev;
    }
}
