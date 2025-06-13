package org.example.model;

public interface NAryTree {

    int getRoot();
    NAryTree get(int index);
    void remove(int index);
    void add(int a, int index);

}
