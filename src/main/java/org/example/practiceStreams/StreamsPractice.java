package org.example.practiceStreams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {
    public static void main(String[] args) {


        //find all evennumbers from a list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        //partioning
        Map<Boolean, List<Integer>> collect4 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Even: " +collect4.get(true));
        System.out.println("Odd: " +collect4.get(false));


        List<Integer> res = list.stream().filter(x -> x % 2 == 0).toList();
        System.out.println(res);

        int[] arr = {1,2,3,4,5,6,7};
        Arrays.stream(arr).filter(x -> x%2==0).forEach(System.out::println);

        //summing
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);


        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());


        //sorting
        List<Integer> sort = list.stream().sorted((x, y) -> y - x).toList();
        System.out.println(sort);



        //sorting string
        //sorting string
        List<String> list3 = new ArrayList<>();
        list3.add("apple");
        list3.add("kiwi");
        list3.add("banana");
        list3.add("pineapple");
        list3.add("mango");
        list3.add("apple");

        List<String> strsort = list3.stream().sorted((x, y) -> y.length() - x.length()).toList();
        System.out.println(strsort);

        Map<String, Long> collect = strsort.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect);


        //count freq
        String str = "this this is a java practice of java java";
        System.out.println( Arrays.stream(str.split("\\s+"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())));


        String str1 = "Hello, World!";
        Map<Character, Long> collect1 = str1.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect1);



        List<List<Integer>> list4 = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );

        List<Integer> list1 = list4.stream().flatMap(x -> x.stream()).toList();
        System.out.println(list1);
        System.out.println(list1.reversed());


        //flatmap of string
        List<List<String>> list5 = Arrays.asList(
                Arrays.asList("apple","kiwi"),
                Arrays.asList("pineapple","banana"),
                Arrays.asList("mango","grapes")
        );

        List<String> list2 = list5.stream().flatMap(x -> x.stream()).toList();
        System.out.println(list2);
        System.out.println(list2.stream().sorted((x,y) -> x.length() - y.length()).toList());
        System.out.println(list2.stream().sorted((x,y) -> x.length() - y.length()).toList().reversed());
        System.out.println(list2.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
        System.out.println(list2.stream().collect(Collectors.groupingBy(x -> x.length(), Collectors.counting())));



        //grouping by department
        List<Emp> emp = Arrays.asList(
                new Emp("Shubham","Engineering"),
                new Emp("Ankit","Engineering"),
                new Emp("Atul","Analyst"),
                new Emp("Neha","HR"),
                new Emp("Akshit","Sales")
        );

        Map<String, Long> collect2 = emp.stream()

                .collect(Collectors.groupingBy(x -> x.dept, Collectors.counting()));
        System.out.println(collect2);



        //joining string
        List<String> list6 = Arrays.asList("apple","grapes","banana");
        String collect3 = list6.stream().collect(Collectors.joining(", "));
        System.out.println(collect3);


        //Top N Problem
        List<Stu> list7 = Arrays.asList(
                new Stu("Ankit",91),
                new Stu("Shubham",99),
                new Stu("David",79),
                new Stu("Bob",97),
                new Stu("Charlie",88)

        );

        List<Stu> topN = list7.stream()
                .sorted((x, y) -> y.marks - x.marks)
                .limit(3)
                .toList();
        System.out.println(topN);




        //find char freq
        String name = "Ankit";
        Map<Character, Long> collect5 = name.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect5);


        //how to find the longest string in a list
        List<String> list9= Arrays.asList("apple","pineapple","banana","kiwi");
        Optional<String> max = list9.stream()
                .max((x, y) -> Integer.compare(x.length(), y.length()));
        System.out.println(max.get());



        //count the number of element in a list
        List<String> list10 = Arrays.asList("apple","kiwi","pineapple");
        Long collect6 = list10.stream().collect(Collectors.counting());
        System.out.println(collect6);



        //list of unique characters from a string array
        String[] strr = {"Hello","World"};
        Map<Character, Long> collect7 = Arrays.stream(strr)
                .flatMap((x) -> x.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()));


        System.out.println(collect7);


        //find first non empty String in a list
        List<String> list12 = Arrays.asList(""," ","Hello","world");
        System.out.println(list12.stream()
                .filter(x -> !x.trim().isEmpty())
                .findFirst().orElse("None"));


        //        APPL_Unitrax | Role_Admin | APPL_WL
//        Output : Admin
        String word = "APPL_Unitrax | Role_Admin | APPL_WL";

        List<String> list8 = Arrays.stream(word.split("[|]"))
                .filter(x -> x.contains("Role_"))
                .map(x -> x.trim())
                .map(x -> x.replace("Role_", ""))
                .toList();
        System.out.println(list8);


        //count word freq
        String input = "Hello world ! Hello, Java";
        Map<String, Long> collect8 = Arrays.stream(input.split("[\\W]+"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect8);


        //reverse a string
        String reverse = "Hello World this is java";
        String string = new StringBuilder(reverse).reverse().toString();
        System.out.println(string);


    }
}


class Emmpp{
    String name;
    String dept;


    public Emmpp(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emmpp{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
