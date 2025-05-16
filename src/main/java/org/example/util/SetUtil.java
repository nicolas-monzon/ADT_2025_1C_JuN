package org.example.util;

import org.example.model.Set;
import org.example.model.StaticSet;

public class SetUtil {

    public static Set copy(Set set) {
        Set result = new StaticSet();
        Set aux = new StaticSet();

        while(!set.isEmpty()) {
            int chosen = set.choose();
            result.add(chosen);
            aux.add(chosen);
            set.remove(chosen);
        }

        while(!aux.isEmpty()) {
            int chosen = aux.choose();
            set.add(chosen);
            aux.remove(chosen);
        }

        return result;
    }

    public static boolean in(int a, Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int chosen = copy.choose();
            if(chosen == a) {
                return true;
            }
            copy.remove(chosen);
        }
        return false;
    }

    public static boolean subsetEq(Set set, Set set2) {
        Set copy = copy(set);

        while(!copy.isEmpty()) {
            int chosen = copy.choose();
            if(!in(chosen, set2)) {
                return false;
            }
            copy.remove(chosen);
        }
        return true;
    }

    public static int size(Set set) {
        Set copy = copy(set);

        int size = 0;
        while(!copy.isEmpty()) {
            size++;
            copy.remove(copy.choose());
        }
        return size;
    }

    public static Set intersection(Set set, Set set2) {
        Set copy = copy(set);
        Set result = new StaticSet();

        while(!copy.isEmpty()) {
            int chosen = copy.choose();
            if(in(chosen, set2)) {
                result.add(chosen);
            }
            copy.remove(chosen);
        }
        return result;
    }

    public static Set union(Set set, Set set2) {
        Set copy = copy(set);
        Set copy2 = copy(set2);

        while(!copy2.isEmpty()) {
            int chosen = copy2.choose();
            copy.add(chosen);
            copy2.remove(chosen);
        }
        return copy;
    }

    public static Set difference(Set set, Set set2) {
        Set copy = copy(set);
        Set result = new StaticSet();

        while(!copy.isEmpty()) {
            int chosen = copy.choose();
            if(!in(chosen, set2)) {
                result.add(chosen);
            }
            copy.remove(chosen);
        }
        return result;
    }

    public static Set symmetricDifference(Set set, Set set2) {
        return union(difference(set, set2), difference(set2, set));
    }

    public static boolean equals(Set set, Set set2) {
        return subsetEq(set, set2) && subsetEq(set2, set2);
    }

}
