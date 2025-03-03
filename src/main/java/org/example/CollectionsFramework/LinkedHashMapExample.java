package org.example.CollectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();

//        hashMap.put("Orange",10);
//        hashMap.put("Apple",20);
//        hashMap.put("Guava",13);
//
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey()+ ": " +entry.getValue());
//        }

        linkedHashMap.put("Orange",10);
        linkedHashMap.put("Apple",20);
        linkedHashMap.put("Guava",13);

        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey()+ ": " +entry.getValue());
        }

        //converting hashmap into linkedhashmap
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap linkedHashMap1 = new LinkedHashMap(hashMap);

        hashMap.put("Shubham", 91);
        hashMap.put("Bob",80);
        hashMap.put("Akshit",78);

        Integer res = hashMap.getOrDefault("Shubham", 0);
        System.out.println(res);

        hashMap.putIfAbsent("Shubham", 92);
        hashMap.putIfAbsent("Ankit",99);
        System.out.println(hashMap);
    }
}
