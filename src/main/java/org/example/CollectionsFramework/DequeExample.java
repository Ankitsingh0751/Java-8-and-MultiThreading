package org.example.CollectionsFramework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>(); //faster iteration since its an array (continous memory allocation), low memory, no null allowed
        deque1.addFirst(10);
        deque1.addLast(20);
        deque1.offerFirst(5);
        deque1.offerLast(25);
        System.out.println(deque1);

        //5,10,20,25
        System.out.println("First Element: " +deque1.getFirst());
        System.out.println("Last Element: " +deque1.getLast());
        deque1.removeFirst();
        deque1.poll();
        //current deque - [10,20]
        for(int num : deque1){
            System.out.println(num);
        }



        Deque<Integer> deque2 = new LinkedList<>();

    }
}
