package org.example.CollectionsFramework;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        pq1.add(15);
        pq1.add(10);
        pq1.add(30);
        pq1.add(5);

        pq2.add(15);
        pq2.add(10);
        pq2.add(30);
        pq2.add(5);

        System.out.println(pq);   //not sorted
        System.out.println(pq1);
        System.out.println(pq2);
//        System.out.println(pq.peek());
//        System.out.println(pq.remove());
//        System.out.println(pq.peek());

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }



    }
}
