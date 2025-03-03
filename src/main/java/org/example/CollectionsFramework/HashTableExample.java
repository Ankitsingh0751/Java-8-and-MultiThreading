package org.example.CollectionsFramework;

import java.util.HashMap;
import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
//        Hashtable<Integer, String> hashtable = new Hashtable<>();
//        hashtable.put(1,"Apple");
//        hashtable.put(2,"Banana");
//        hashtable.put(3,"Cherry");
//        System.out.println(hashtable);
//        System.out.println("Value for key 2: " +hashtable.get(2));
//        System.out.println("Does key 3 exists ? " +hashtable.containsKey(3));
//        hashtable.remove(1);
//        System.out.println("After removing key 1: " +hashtable);
////        hashtable.put(null,"Value"); //exception
////        hashtable.put(4,null);  // exception


        HashMap<Integer, String> map = new HashMap<>();
        Thread thread = new Thread(() -> {
            for(int i = 0;i<1000;i++){
                map.put(i,"Thread1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i,"Thread2");
            }
        });
        thread.start();
        thread2.start();
        try{
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final size of hashMap: " +map.size());


    }
}
