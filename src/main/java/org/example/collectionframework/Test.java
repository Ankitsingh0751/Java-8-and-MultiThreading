package org.example.collectionframework;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

//        Node node = new Node();
//        Node node2 = new Node();
//        node.value = 1;
//        node.next = node2;
//        node2.value = 2;
//        node2.next = null;


        LinkedList<Integer> linkedlist = new LinkedList<>();

        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);

        //linked list methods
        linkedlist.addFirst(0);
        linkedlist.addLast(4);
        System.out.println(linkedlist);

        linkedlist.clone();
        System.out.println(linkedlist);

        System.out.println(linkedlist.contains(3));

        LinkedList<Integer> newlist = new LinkedList<>(Arrays.asList(5,6,7,8));
        linkedlist.addAll(newlist);

        System.out.println(linkedlist);


        linkedlist.add(2,10);

        System.out.println(linkedlist);

        System.out.println(linkedlist.get(2));

        System.out.println(linkedlist.getFirst());
        System.out.println(linkedlist.getLast());

        System.out.println(linkedlist.indexOf(8));

        System.out.println(linkedlist.lastIndexOf(5));

        System.out.println(linkedlist.offer(15));
        System.out.println(linkedlist);


        System.out.println(linkedlist.peek());
        System.out.println(linkedlist.peekFirst());
        System.out.println(linkedlist.peekLast());
        System.out.println(linkedlist.poll());
        System.out.println(linkedlist);

        System.out.println(linkedlist.pop());
        System.out.println(linkedlist);
        System.out.println(linkedlist.remove());
        System.out.println(linkedlist);
        System.out.println(linkedlist.removeFirstOccurrence(5));
        System.out.println(linkedlist);

        linkedlist.add(5);
        linkedlist.add(5);
        linkedlist.add(3,5);
        System.out.println(linkedlist);

        System.out.println(linkedlist.removeLastOccurrence(5));
        System.out.println(linkedlist);


        System.out.println(linkedlist.reversed());
        linkedlist.set(7,9);
        System.out.println(linkedlist);


        System.out.println(linkedlist.size());

        System.out.println(linkedlist.containsAll(newlist));

        System.out.println(linkedlist.equals(newlist));

        System.out.println(linkedlist.hashCode());
    }
}


class Node{
    public int value;
    public Node next;
}
