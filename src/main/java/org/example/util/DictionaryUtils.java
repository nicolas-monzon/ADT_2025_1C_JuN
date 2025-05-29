package org.example.util;

import org.example.model.Dictionary;
import org.example.model.Set;
import org.example.model.StaticDictionary;
import org.example.model.StaticSet;

public class DictionaryUtils {

    private DictionaryUtils() {

    }

    public static Dictionary copy(Dictionary dictionary) {
        Set keys = dictionary.getKeys();
        Dictionary result = new StaticDictionary();

        while(!keys.isEmpty()) {
            int chosen = keys.choose();
            result.add(chosen, dictionary.getValue(chosen));
            keys.remove(chosen);
        }
        return result;
    }

    public static boolean existsInverse(Dictionary dictionary) {
        Set keys = dictionary.getKeys();
        Set values = new StaticSet();

        while(!keys.isEmpty()) {
            int chosen = keys.choose();
            values.add(dictionary.getValue(chosen));
            keys.remove(chosen);
        }
        return SetUtil.size(keys) == SetUtil.size(values);
    }

}
