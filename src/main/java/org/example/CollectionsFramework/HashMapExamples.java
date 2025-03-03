package org.example.CollectionsFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExamples {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Ankit");
        hashMap.put(2,"Atul");
        hashMap.put(3,"Akshit");
        hashMap.put(4,"Neha");

        System.out.println(hashMap);
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(34));
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.containsValue("Ankit"));
        for(int i : hashMap.keySet()){
            System.out.println(hashMap.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries){
            //System.out.println(entry.getKey()+ ": " +entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(hashMap);

        //hashMap.remove(2);
        boolean res = hashMap.remove(2, "Neha");
        System.out.println("Removed ? : " +res);

        System.out.println(hashMap);


    }
}
