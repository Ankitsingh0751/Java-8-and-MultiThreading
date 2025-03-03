package org.example.CollectionsFramework;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>((a,b) -> b-a);
        sortedMap.put(91, "Vivek");
        sortedMap.put(99,"Shubham");
        sortedMap.put(78,"Mohit");
        sortedMap.put(77,"Vipul");
        System.out.println(sortedMap);

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        System.out.println(sortedMap.headMap(91));  //exclude
        System.out.println(sortedMap.tailMap(91));  //include
        System.out.println(sortedMap);





    }
}
