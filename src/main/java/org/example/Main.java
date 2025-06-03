package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main { // Manim
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "b");
        if (hashMap.containsKey("a")) {
            System.out.println(hashMap.get("a"));
        }
    }
}