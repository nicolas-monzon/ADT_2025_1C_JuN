package org.example.model;

public interface MultipleDictionary {

    void add(int k, int v);

    void remove(int k, int v);

    Set getKeys();

    List getValues(int k);

}
