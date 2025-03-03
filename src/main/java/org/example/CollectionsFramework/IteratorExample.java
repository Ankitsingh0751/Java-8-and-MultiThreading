package org.example.CollectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i : list){
            System.out.println(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
//        for(Integer number : list1){
//            if(number%2 ==0){
//                list1.remove(number);
//            }
//        }

        Iterator<Integer> itr = list1.iterator();
        while(itr.hasNext()){
            Integer number = itr.next();
            if(number %  2 ==0){
                itr.remove();
            }
        }
        System.out.println(list1);

        ListIterator<Integer> listIterator = list1.listIterator();
        while (listIterator.hasNext()){
            listIterator.set(2);
        }
        //



    }
}
