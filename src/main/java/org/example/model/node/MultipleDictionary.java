package org.example.model.node;

import org.example.model.List;
import org.example.model.Set;

public interface MultipleDictionary {

    void add(int k, int v);

    void remove(int k, int v);

    Set getKeys();

    List getValues(int k);

}
