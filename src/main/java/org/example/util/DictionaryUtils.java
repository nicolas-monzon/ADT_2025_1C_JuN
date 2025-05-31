package org.example.util;

import org.example.model.*;
import org.example.model.node.MultipleDictionary;

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

    public static Dictionary union(Dictionary dictionary1, Dictionary dictionary2) {
        Set keys = dictionary1.getKeys();
        Set keys2 = dictionary2.getKeys();
        Set intersectionKeys = SetUtil.intersection(keys2, keys);
        while(!intersectionKeys.isEmpty()) {
            int chosen = intersectionKeys.choose();
            if(dictionary1.getValue(chosen) != dictionary2.getValue(chosen)) {
                throw new RuntimeException("No se pueden unir los diccionarios");
            }
            intersectionKeys.remove(chosen);
        }
        Dictionary result = copy(dictionary1);
        while(!keys2.isEmpty()) {
            int chosen = keys2.choose();
            result.add(chosen, dictionary2.getValue(chosen));
            keys2.remove(chosen);
        }
        return result;
    }

    public static MultipleDictionary copy(MultipleDictionary dictionary) {
        Set keys = dictionary.getKeys();
        MultipleDictionary result = new DynamicMultipleDictionary();

        while(!keys.isEmpty()) {
            int chosen = keys.choose();
            List values = dictionary.getValues(chosen);
            int size = values.size();
            for(int i = 0; i < size; i++) {
                result.add(chosen, values.get(i));
            }
            keys.remove(chosen);
        }

        return result;
    }

    public static MultipleDictionary diff(MultipleDictionary dictionary1, MultipleDictionary dictionary2) {
        MultipleDictionary result = copy(dictionary1);

        Set keys2 = dictionary2.getKeys();
        while(!keys2.isEmpty()) {
            int chosen = keys2.choose();
            List values = dictionary2.getValues(chosen);
            int size = values.size();
            for(int i = 0; i < size; i++) {
                result.remove(chosen, values.get(i));
            }
            keys2.remove(chosen);
        }
        return result;
    }

}
