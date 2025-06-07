package org.example.model;

public class StaticBinaryTree implements BinaryTree {

    private static final int TOTAL_LEVELS = 30;

    private final Integer[] values;
    private final int indexRoot;

    public StaticBinaryTree(int root) {
        values = new Integer[(int) Math.pow(2,  TOTAL_LEVELS) - 1];
        indexRoot = 0;
        values[indexRoot] = root;
    }

    private StaticBinaryTree(int indexRoot, Integer[] values) {
        this.values = values;
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return values[indexRoot];
    }

    @Override
    public StaticBinaryTree getLeft() {
        return new StaticBinaryTree(2*indexRoot + 1, values);
    }

    @Override
    public StaticBinaryTree getRight() {
        return new StaticBinaryTree(2*indexRoot + 2, values);
    }

    @Override
    public void removeLeft() {
        StaticBinaryTree left = this.getLeft();
        if(left == null) {
            throw new RuntimeException("No se puede eliminar un hijo que no existe");
        }

        if(left.getLeft() != null) {
            left.removeLeft();
        }
        if(left.getRight() != null) {
            left.removeRight();
        }

        values[2*indexRoot + 1] = null;
    }

    @Override
    public void removeRight() {
        StaticBinaryTree right = this.getRight();
        if(right == null) {
            throw new RuntimeException("No se puede eliminar un hijo que no existe");
        }

        if(right.getLeft() != null) {
            right.removeLeft();
        }
        if(right.getRight() != null) {
            right.removeRight();
        }

        values[2*indexRoot + 2] = null;
    }

    @Override
    public void addLeft(int a) {
        StaticBinaryTree left = this.getLeft();
        if(left != null) {
            throw new RuntimeException("No se puede pisar un hijo que ya existe");
        }
        this.values[2*indexRoot + 1] = a;
    }

    @Override
    public void addRight(int a) {
        StaticBinaryTree right = this.getRight();
        if(right != null) {
            throw new RuntimeException("No se puede pisar un hijo que ya existe");
        }
        this.values[2*indexRoot + 2] = a;
    }
}
