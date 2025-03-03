package org.example.CollectionsFramework;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheExample<k,v> extends LinkedHashMap<k,v> {

    private int capacity;

    public LRUCacheExample(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheExample<String, Integer> studentMap = new LRUCacheExample<>(3);

        studentMap.put("Bob",99);
        studentMap.put("Alice",89);
        studentMap.put("Ram",91);


        //remove method invoked
        studentMap.get("Bob");
        studentMap.put("Bob",100);

        studentMap.put("vipul",100);
        System.out.println(studentMap);
    }
}
