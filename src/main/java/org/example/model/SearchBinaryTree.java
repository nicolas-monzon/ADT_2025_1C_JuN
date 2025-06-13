package org.example.model;

public interface SearchBinaryTree {

    int getRoot();
    SearchBinaryTree getLeft();
    SearchBinaryTree getRight();
    void removeLeft();
    void removeRight();
    void add(int a);

}
