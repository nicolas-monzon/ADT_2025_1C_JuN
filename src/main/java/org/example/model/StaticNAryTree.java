package org.example.model;

public class StaticNAryTree implements NAryTree {

    private static final int TOTAL_LEVELS = 5;

    private final Integer[] values;
    private final int indexRoot;
    private final int n;

    public StaticNAryTree(int root, int n) {
        if(n > 50) {
            throw new RuntimeException("n out of range");
        }
        values = new Integer[((int) Math.pow(n,  TOTAL_LEVELS) - 1) / (n - 1)];
        indexRoot = 0;
        values[indexRoot] = root;
        this.n = n;
    }

    private StaticNAryTree(int indexRoot, Integer[] values, int n) {
        this.values = values;
        this.indexRoot = indexRoot;
        this.n = n;
    }

    @Override
    public int getRoot() {
        return values[indexRoot];
    }

    @Override
    public StaticNAryTree get(int index) {
        checkIndex(index);
        if(n*indexRoot + 1 + index >= this.values.length) {
            return null;
        }
        return new StaticNAryTree(n*indexRoot + 1 + index, values, n);
    }

    @Override
    public void remove(int index) {
        StaticNAryTree tree = this.get(index);
        if(tree == null) {
            throw new RuntimeException("No se puede eliminar un hijo que no existe");
        }

        for(int i = 0; i < n; i++) {
            if(this.get(index).get(i) != null) {
                this.get(index).remove(i);
            }
        }

        values[n*indexRoot + 1 + index] = null;
    }

    @Override
    public void add(int a, int index) {
        StaticNAryTree tree = this.get(index);
        if(tree != null) {
            throw new RuntimeException("No se puede pisar un hijo que ya existe");
        }
        this.values[n*indexRoot + 1 + index] = a;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= n) {
            throw new RuntimeException("index out of range");
        }
    }
}
