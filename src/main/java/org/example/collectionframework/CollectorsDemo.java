package org.example.collectionframework;

import java.net.http.HttpClient;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        //collectors is a utility class
        //provides a set of methods to create common collectors

        //1.collecting to a list
        List<String> list  = Arrays.asList("Alice","Bob","Charlie");
        List<String> res = list.stream()
                .filter((x) -> x.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        //2. collecting to a set

        List<Integer> nums = Arrays.asList(1,2,2,3,4,5);
        System.out.println(nums
                .stream()
                .collect(Collectors.toSet()));


        //3. collecting to a specific collection
        //we can convert to arraylist,linkedlist,arraydeque
        ArrayDeque<String> collect = list
                .stream()
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        ArrayList<String> collect1 = list
                .stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));


        //4. Joining Strings
        // concatenates stream elements into a single stream
        String concatenatenames = list.stream().map(String::toUpperCase).collect(Collectors.joining(", "));

        System.out.println(concatenatenames);


        //5.summarizing data
        //generates statistical summary (count,sum,min, average,max)

        List<Integer> nums1 = Arrays.asList(2,3,5,7,9);
        IntSummaryStatistics stats = nums1.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " +stats.getCount());
        System.out.println("Sum: " +stats.getSum());
        System.out.println("Min: " +stats.getMin());
        System.out.println("Average: " +stats.getAverage());
        System.out.println("Max: " +stats.getMax());

        //6.calculating average
        Double average = nums1.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " +average);


        //7.Counting element
        Long count = nums1.stream().collect(Collectors.counting());
        System.out.println("Count: " +count);

        //8.grouping element
        List<String> names = Arrays.asList("Hello","world","java","streams","collecting");
        System.out.println(names.stream().collect(Collectors.groupingBy(x -> x.length())));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(names.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
        TreeMap<Integer, Long> treemap = names.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treemap);



        //9. partitioning elements
        //partitions elements into two groups (true and false) based on a predicate
        System.out.println(names.stream().collect(Collectors.partitioningBy(x -> x.length() >5)));

        //10. mapping and collecting
        System.out.println(names.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));


        //11. tomap

        //examples
        //1. collecting names by length
        List<String> l1 = Arrays.asList("Anna","Bob","Alexander","Brian","Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(x -> x.length())));

        //2.counting word occurance
        String sentence = "Hello world hello java world world";
        System.out.println(Arrays.stream(sentence.split(" ")).map((String::toUpperCase)).collect(Collectors.groupingBy(x -> x , Collectors.counting())));


        //3. partitioning even and odd numbers
        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x%2==0)));


        //4. summing values in a map
        Map<String,Integer> items = new HashMap<>();
        items.put("Apple",10);
        items.put("banana",20);
        items.put("Oranges",15);

        System.out.println(items.values().stream().reduce(Integer::sum).get());
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));


        //6. creating a map from stream elements
        List<String> fruits  = Arrays.asList("Apple","Banana","Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x-> x.length())));


        //6. using tomap count the stirng occurance
        List<String> words = Arrays.asList("apple","banana","apple","orange","apple");
        System.out.println(words.stream().collect(Collectors.toMap(k->k, v -> 1, (x,y) -> x+y)));

    }
}
