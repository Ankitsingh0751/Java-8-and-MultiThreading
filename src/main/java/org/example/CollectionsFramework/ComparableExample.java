package org.example.CollectionsFramework;

import org.example.MultiThreadinglearning.Student;
import org.example.collectionframework.Students;

import java.util.ArrayList;
import java.util.List;

public class ComparableExample {
    public static void main(String[] args) {
        List<Students> list = new ArrayList<>();
        list.add(new Students("Ankit", 3.9));
        list.add(new Students("Bob", 3.7));
        list.add(new Students("Charlie", 3.5));
        list.add(new Students("Atul", 3.5));
        list.sort(null);
        System.out.println(list);

//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1);
//        list1.add(5);
//        list1.add(4);
//        list1.add(3);
//        list1.add(2);
//        list1.sort(null);
//        System.out.println(list1);
    }
}
