package org.example.practiceStreams;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreExamplesStreams {
    public static void main(String[] args) {

        //list of strings to uppercase
        List<String> list = Arrays.asList("apple","Kiwi","banana");
        System.out.println(list.stream().map((x) -> x.toUpperCase()).toList());

        //how to find the longest string in a list
        List<String> list1 = Arrays.asList("apple","pineapple","banana","kiwi");
        String noStrings = list1.stream().max((s1, s2) -> Integer.compare(s1.length(), s2.length())).orElse("No Strings");
        System.out.println(noStrings);


        //join elements of a string array into a single string
        List<String> list2 = Arrays.asList("apple","kiwi","banana","pineapple");
        //System.out.println(list2.stream().sorted((x,y) -> y.length() - x.length()).toList());
        System.out.println(list2.stream().collect(Collectors.joining(", ")));

        //count the number of element in a list
        List<String> list3 = Arrays.asList("apple","kiwi","pineapple");
        System.out.println(list3.stream().count());

        //count even numbers in a list
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list4.stream().filter((x) -> x%2==0).toList());

        //even numbers from an array
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(Arrays.stream(arr).filter((x) -> x % 2 == 0).toArray()));


        ///sort an list in reverse
        List<Integer> list5 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list5.stream().sorted((x,y) -> x-y).toList().reversed());


        //find sum of array and a list

        int[] arr2 = {1,2,3,4,5};
        System.out.println(Arrays.stream(arr2).sum());

        List<Integer> list6 = Arrays.asList(1,2,3,4,5);
        System.out.println(list6.stream().reduce((x,y)-> x+y).get());


        //grouping string by their length using collectors
        List<String> list7 = Arrays.asList("apple","mango","kiwi","lichi","pineapple","aadu");
        System.out.println(list7.stream().collect(Collectors.groupingBy(String::length, Collectors.toList())));


        //list of unique characters from a string array

        String[] str = {"Hello","World"};
        System.out.println(Arrays.stream(str).flatMap((x) -> x.chars().mapToObj(c-> (char) c)).collect(Collectors.toSet()));

        //find first non empty String in a list
        List<String> list8 = Arrays.asList(""," ","Hello","world");
        System.out.println(list8.stream().filter((x) -> !x.trim().isEmpty())
                .findFirst()
                .orElse("No Empty String"));




        //partition into even and odd
        List<Integer> list9 = Arrays.asList(1,2,3,4,5,6,7,8);
        Map<Boolean, List<Integer>> ans = list9.stream().collect(Collectors.partitioningBy((x) -> x % 2 == 0, Collectors.toList()));
        System.out.println("Even: " +ans.get(true));
        System.out.println("Odd: " +ans.get(false));


        //concatenating multiple string using streams

        String str2 = Stream.of("Hi","Java","8 is fun").collect(Collectors.joining(" "));
        System.out.println(str2);


        //sort a list in reverse
        List<String> list11 = Arrays.asList("apple","orange","kiwi","pineapple","mango");
        System.out.println(list11.stream().sorted().toList().reversed());




    }
}
