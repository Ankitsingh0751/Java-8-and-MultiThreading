package org.example.CollectionsFramework;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        String key1 = new String("Key");
        String key2 = new String("Key");
//        Map<String, Integer> map = new HashMap<>();
//        map.put(key1, 1);
//        map.put(key2,2);
//        System.out.println(key1.equals(key2));
//        System.out.println(map);

        //but if we make it identityhashmap


        Map<String, Integer> map = new IdentityHashMap<>();
        map.put(key1, 1);
        map.put(key2,2);
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());
        //System.out.println(key1.equals(key2));
        System.out.println(map);


    }
}
