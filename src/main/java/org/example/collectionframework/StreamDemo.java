package org.example.collectionframework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        //feature introduced in java 8
        //process collections of data in a functional and declarative manner
        //simplify data processing
        //improve readability and maintainability
        //enable easy parallelism


        //how to use Stream?
        //a sequence of elements supporting functional and declarative programing
        //source , intermideate operation & terminal operation


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //to find count of even numbers
//        int count = 0;
//        for (int i : list) {
//            if (i % 2 == 0) {
//                count++;
//            }
//
//        }
//        System.out.println(count);

        System.out.println(list.stream().filter((x) -> x%2 ==0).count());

        //creating stream
        //1. from collections
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //2. from array
        String[] array = {"a","b","c"};
        Stream<String> stream1 = Arrays.stream(array);

        //3. using stream.of()
        Stream<String> stream2 = Stream.of("a","b");

        //4. infinite stream
        Stream<Integer> generate = Stream.generate(() -> 1);
        List<Integer> iterate = Stream.iterate(1,x->x+1).limit(100).collect(Collectors.toList());
        System.out.println(iterate);
        //limit
        Stream<Integer> generate1 = Stream.generate(() -> 1).limit(100);





    }
}