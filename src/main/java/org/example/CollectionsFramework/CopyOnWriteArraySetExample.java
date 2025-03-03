package org.example.CollectionsFramework;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {
    public static void main(String[] args) {


        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet  = new ConcurrentSkipListSet<>();

        for (int i = 1; i <= 5; i++) {
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("Initial CopyOnWriteArraySet: " +copyOnWriteArraySet);
        System.out.println("Initial ConcurrentSkipListSet: " +concurrentSkipListSet);

        System.out.println("\nIterating and modifying CopyOnWrtireArraySet:");
        for(Integer num : copyOnWriteArraySet){
            System.out.println("Reading from copyOnWriteArraySet: " +num);
            //Attempting to modify the sdet during iteration
            copyOnWriteArraySet.add(6);
        }
        //System.out.println(copyOnWriteArraySet);

        System.out.println("\nIterating and modifying ConcurrentSkipListSet:");
        for(Integer num: concurrentSkipListSet){
            System.out.println("Reading from ConcurrentSkipListSet: " +num);
            //Attempting to modify the set during iteration
            if(num == 5){
                concurrentSkipListSet.add(6);
            }
        }
    }
}
