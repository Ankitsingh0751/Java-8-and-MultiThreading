package org.example.CollectionsFramework;

import java.util.Arrays;
import java.util.LinkedList;

public class linkedListExamplesdemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.get(2);
        list.addLast(5);
        list.addFirst(0);
        list.getFirst();
        list.getLast();
        System.out.println(list);
        list.removeIf(x -> x%2==0);

        System.out.println(list);



        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat","Dog","Elephant"));
        LinkedList<String> ainmalsToRemove = new LinkedList<>(Arrays.asList("Cat","Dog","Lion"));
        animals.removeAll(ainmalsToRemove);
        System.out.println(animals);





    }
}
