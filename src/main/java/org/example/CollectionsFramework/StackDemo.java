package org.example.CollectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        stack.pop();
        System.out.println(stack);


        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.search(3));



        //inheriting vector method
        stack.add(2,9);
        System.out.println(stack);


        //linkedlist as stack
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println(list.getLast()); //works as a peek instack
        System.out.println(list.removeLast()); //work as pop
        System.out.println(list.size());
        System.out.println(list.isEmpty());


        //arraylist as a stack

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println(arrayList);
        System.out.println(arrayList.get(arrayList.size() - 1));  //peek
        System.out.println(arrayList.remove(arrayList.size() - 1));   //pop
        System.out.println(arrayList);







    }
}
