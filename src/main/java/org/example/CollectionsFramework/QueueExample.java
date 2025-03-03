package org.example.CollectionsFramework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {
    public static void main(String[] args) {

        //linkedlist as a queue
//        LinkedList<Integer> queue1 = new LinkedList<>();
//        queue1.addLast(1);
//        queue1.addLast(2);
//        queue1.addLast(3);
//        System.out.println(queue1);
//        queue1.removeFirst();
//        System.out.println(queue1);
//        System.out.println(queue1.getFirst());



        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        System.out.println(queue1);
        queue1.remove();
        System.out.println(queue1);
        System.out.println(queue1.peek());
        System.out.println(queue1.size());


        //both are same
        //System.out.println(queue1.remove()); //throws execption
        System.out.println(queue1.poll());


        //
        //System.out.println(queue1.element()); // throws exception
        System.out.println(queue1.peek());



        Queue<Integer> queue2 = new ArrayBlockingQueue<>(2);
        System.out.println(queue2.add(1));  //true
        System.out.println(queue2.offer(2));  //true
        //System.out.println(queue2.add(3)); //throws exception
        System.out.println(queue2.offer(3));  //false








    }
}
