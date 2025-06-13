package org.example.model;

public class DynamicNAryTree implements NAryTree {

    private final int root;
    private NAryTreeList list;
    private final int n;

    public DynamicNAryTree(int root, int n) {
        this.root = root;
        this.list = new NAryDLinkedList();
        for(int i = 0; i < n; i++) {
            list.add(null);
        }
        this.n = n;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public NAryTree get(int index) {
        checkIndex(index);
        return list.get(index);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        NAryTree tree = this.get(index);
        if(tree == null) {
            throw new RuntimeException("No se puede eliminar un hijo que no existe");
        }
        NAryTreeList newList = new NAryDLinkedList();
        for(int i = 0; i < this.n; i++) {
            if(i != index) {
                newList.add(this.list.get(i));
            } else {
                newList.add(null);
            }
        }

        this.list = newList;
    }

    @Override
    public void add(int a, int index) {
        checkIndex(index);
        NAryTree tree = this.get(index);
        if(tree != null) {
            throw new RuntimeException("No se puede pisar un hijo que ya existe");
        }
        NAryTreeList newList = new NAryDLinkedList();
        for(int i = 0; i < this.n; i++) {
            if(i != index) {
                newList.add(this.list.get(i));
            } else {
                newList.add(new DynamicNAryTree(a, n));
            }
        }

        this.list = newList;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= n) {
            throw new RuntimeException("index out of range");
        }
    }
}
