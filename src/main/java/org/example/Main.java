package org.example;

import org.example.collectionframework.Students;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class MyComprator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}

class StringCompareWords implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}




public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        //collection sort we can use and also we can use list.sort as well
        //list.sort(null);   //this does the deafult sort which is ascending order.
        Collections.sort(list);
        System.out.println("sorted list: " +list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list1.add(3);

        //converting list into array
        Object[] array = list1.toArray();
        Integer[] array1 = list.toArray(new Integer[0]);

        //removing element as a object not as a index
        list1.remove(Integer.valueOf(1));  // converting it into wrapper class , hence it will take object rather than the index of the element.
        System.out.println("item removed: " +list1);


        //java -9
        //addall method
        List<Integer> arr = List.of(4,5,6,7);
        list1.addAll(arr);
        System.out.println("List: " +list1);
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(2);
//        System.out.println(list);
//
//        list.remove(2);
//        System.out.println(list);
//        list.add(2,50);
//
//        System.out.println(list);
//
//        list.set(2,100);
//        System.out.println(list);
//
//

        //System.out.println(list.contains(2));

        //System.out.println(list);


//        List<Integer> listadd = Arrays.asList(1,2,3,4);
////        List<String> fruits = Arrays.asList("Apple","Banana","Kiwi");
////        fruits.add("mango");
//        ArrayList<Integer> addfromacollection = new ArrayList<>(listadd);


//        String[] array = {"Apple","Banana","Kiwi"};
//        List<String> addingtolist = Arrays.asList(array);
//        addingtolist.add(1,"seetaphal");



        List<String> words = Arrays.asList("Banana", "Apple","Kiwi");
        //words.sort(new StringCompareWords());
        words.sort((a,b) -> b.length() - a.length());
        System.out.println(words);




        list.add(2);
        list.add(1);
        list.add(3);

        //list.sort(new MyComprator());
        list.sort((a,b) -> a-b);

        System.out.println(list);




        List<Students> student = new ArrayList<>();
        student.add(new Students("Ankit", 3.9));
        student.add(new Students("Bob", 3.7));
        student.add(new Students("Charlie", 3.5));
        student.add(new Students("Atul", 3.5));

//        student.sort((a,b) -> (int) (b.getGpa() - a.getGpa()));
//
//        student.sort((a,b) -> {
//            if(b.getGpa() -a.getGpa() > 0 ){
//                return 1;
//            }else if(b.getGpa() - a.getGpa() <0){
//                return -1;
//            }else{
//                return a.getName().compareTo(b.getName()) ;
//            }
//        });

        //java 8 (method reference)
        //Comparator<Students> comparator = Comparator.comparing(Students::getGpa);
        Comparator<Students> comparator = Comparator.comparing(Students::getGpa).reversed().thenComparing(Students::getName);
        //student.sort(comparator);
        Collections.sort(student,comparator);  //both ways
//
        for(Students s: student){
            System.out.println(s.getName() + ": " +s.getGpa());
        }








    }
}