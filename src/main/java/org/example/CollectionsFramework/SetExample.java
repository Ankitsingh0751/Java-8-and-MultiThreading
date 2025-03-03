package org.example.CollectionsFramework;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(1);
        set1.add(1);
        set1.add(67);
        System.out.println(set1);


        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(12);
        set2.add(1);
        set2.add(1);
        set2.add(67);
        System.out.println(set2);


        Set<Integer> set3 = new TreeSet<>();
        set3.add(12);
        set3.add(1);
        set3.add(1);
        set3.add(67);
        System.out.println(set3);
        System.out.println(set3.remove(67));
        set3.clear();
        System.out.println(set3.isEmpty());
        for (int i : set3) {
            System.out.println(i);

        }



        //for thread safety
        //Set<Integer> integers = Collections.synchronizedSet(set3);  // too much complicationa

        //instead of this use
        //it implements navigableset
        //built in thread safety
        //we can also use sortedset since navigable set extends sorted set
        ConcurrentSkipListSet<Integer> set4 = new ConcurrentSkipListSet<>();

        //unmodifiable set

        Set<Integer> integers1 = Set.of(1,2,3,4,5,23,344,56,67688,234335);
        Collections.unmodifiableSet(integers1);

    }
}
