package org.example.model;

import org.example.model.node.MultipleDictionary;

public class StaticMultipleDictionary implements MultipleDictionary {

    private static final int MAX_SIZE = 10000;
    private final int[][] pairs;
    private int count;

    public StaticMultipleDictionary() {
        pairs = new int[MAX_SIZE][MAX_SIZE];
    }

    @Override
    public void add(int k, int v) {
        for(int i = 0; i < count; i++) {
            if(pairs[i][0] == k) {
                pairs[i][pairs[i][1] + 2] = v;
                pairs[i][1]++;
                return;
            }
        }

        pairs[count][0] = k;
        pairs[count][1] = 1;
        pairs[count][2] = v;
        count++;
    }

    @Override
    public void remove(int key, int value) {
        for(int i = 0; i < count; i++) {
            if(pairs[i][0] == key) {
                for(int j = 0; j < pairs[i][1]; j++) {
                    if(pairs[i][j + 2] == value) {
                        for(int k = j; k < pairs[i][1] - 1; k++) {
                            pairs[i][k + 2] = pairs[i][k + 3];
                        }
                        pairs[i][1]--;
                        if(pairs[i][1] == 0) {
                            pairs[i] = pairs[count - 1];
                            count--;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    @Override
    public Set getKeys() {
        Set result = new StaticSet();
        for(int i = 0; i < count; i++) {
            result.add(pairs[i][0]);
        }
        return result;
    }

    @Override
    public List getValues(int k) {
        List result = new DLinkedList();
        for(int i = 0; i < count; i++) {
            if(pairs[i][0] == k) {
                for(int j = 0; j < pairs[i][1]; j++) {
                    result.add(pairs[i][j + 2]);
                }
                return result;
            }
        }
        throw new RuntimeException("No se encontró la clave");
    }
}
