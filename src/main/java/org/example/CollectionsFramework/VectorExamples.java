package org.example.CollectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class VectorExamples {
    public static void main(String[] args) {

        //constructors of vectors



        Vector<Integer> vector1 = new Vector<>();
        System.out.println(vector1.capacity());
        Vector<Integer> vector2 = new Vector<>(11);
        System.out.println(vector2.capacity());


        Vector<Integer> vector3 = new Vector<>(5);
        System.out.println(vector3.capacity());
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);

        System.out.println(vector3.capacity());



        Vector<Integer> vector4 = new Vector<>(5,3);
        System.out.println(vector4.capacity());
        vector4.add(2);
        vector4.add(2);
        vector4.add(2);
        vector4.add(2);
        vector4.add(2);
        System.out.println(vector4.capacity());
        vector4.add(2);
        System.out.println(vector4.capacity());
        vector4.add(2);
        vector4.add(2);
        vector4.add(2);
        System.out.println(vector4.capacity());



        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        Vector<Integer> vector5 = new Vector<>(linkedList);
        System.out.println(vector5);


        //synchronization example
        //ArrayList<Integer> list = new ArrayList<>();  //since arraylist is not synchronized it will not give 200 all the time
        Vector<Integer> list = new Vector<>(); //since vector is thread safe it gives 2000 everytime
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of the list: " +list.size());


    }
}
