package org.example.model;

public interface Table {

    void put(String k, String v);

    void remove(String key);

    String getValue(String key);

}
