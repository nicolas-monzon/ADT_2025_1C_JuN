package org.example.model;

public class StaticDictionary implements Dictionary {

    private static final int MAX_SIZE = 10000;
    private final int[] keys;
    private final int[] values;
    private int count;

    public StaticDictionary() {
        keys = new int[MAX_SIZE];
        values = new int[MAX_SIZE];
    }

    @Override
    public void add(int k, int v) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == k) {
                throw new RuntimeException("La clave ya exista");
            }
        }

        keys[count] = k;
        values[count] = v;
        count++;
    }

    @Override
    public void remove(int k, int v) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == k) {
                keys[i] = keys[count - 1];
                values[i] = values[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public Set getKeys() {
        Set result = new StaticSet();
        for (int i = 0; i < count; i++) {
            result.add(keys[i]);
        }
        return result;
    }

    @Override
    public int getValue(int k) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == k) {
                return values[i];
            }
        }
        throw new RuntimeException("No se encontró la clave");
    }
}
