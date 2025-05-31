package org.example.model;

// ["AMOR", "ROMA", "SERGIO", "OMAR", "MORA", "RIESGO"] -> "ROMA"
public class HashTable implements Table {

    private static final int DEFAULT_CAPACITY = 10000;
    private final String[] values;
    // private final int nullIndex;

    public HashTable() {
        this.values = new String[DEFAULT_CAPACITY];
        // nullIndex = (int) (Math.random() * DEFAULT_CAPACITY);
    }

    @Override
    public void put(String k, String v) {
        /*if(k == null) {
            values[nullIndex] = v;
            return;
        }*/ // TODO: Falta completar en los demás métodos
        values[k.hashCode() % DEFAULT_CAPACITY] = v;
    }

    @Override
    public void remove(String key) {
        values[key.hashCode() % DEFAULT_CAPACITY] = null;
    }

    @Override
    public String getValue(String key) {
        return values[key.hashCode() % DEFAULT_CAPACITY];
    }
}
