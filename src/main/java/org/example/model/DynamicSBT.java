package org.example.model;

public class DynamicSBT implements SearchBinaryTree {

    private BinaryTree binaryTree;

    public DynamicSBT(int root) {
        binaryTree = new DynamicBinaryTree(root);
    }

    private DynamicSBT(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getRoot() {
        return binaryTree.getRoot();
    }

    @Override
    public SearchBinaryTree getLeft() {
        return new DynamicSBT(binaryTree.getLeft());
    }

    @Override
    public SearchBinaryTree getRight() {
        return new DynamicSBT(binaryTree.getRight());
    }

    @Override
    public void removeLeft() {
        this.binaryTree.removeLeft();
    }

    @Override
    public void removeRight() {
        this.binaryTree.removeRight();
    }

    @Override
    public void add(int a) {
        if(this.binaryTree.getRoot() == a) {
            return;
        }
        if(this.binaryTree.getRoot() > a) {
            if(this.binaryTree.getLeft() == null) {
                this.binaryTree.addLeft(a);
            } else {
                SearchBinaryTree temp = new DynamicSBT(binaryTree.getLeft());
                temp.add(a);
            }
            return;
        }

        if(this.binaryTree.getRight() == null) {
            this.binaryTree.addRight(a);
            return;
        }

        SearchBinaryTree temp = new DynamicSBT(binaryTree.getRight());
        temp.add(a);
    }
}
