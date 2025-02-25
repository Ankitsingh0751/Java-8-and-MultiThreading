package org.example.collectionframework;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {











        //example
        List<String> names = Arrays.asList("Ankit","bob","Virat","Pulkit");
        System.out.println(names.stream().filter((x) -> x.length()>3).toList());

        //2. squaring and sorting numbers
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        System.out.println(nums.stream().map((x) -> x*x).sorted().toList());

        //3.suming values
        List<Integer> nums2 = Arrays.asList(1,2,3,4,5);
        System.out.println(nums2.stream().reduce(Integer::sum).get());


        //4. count

        //5. anymatch,allmatch,nonmatch

        boolean b1 = nums2.stream().anyMatch((x) -> x % 2 == 0);
        boolean b2 = nums2.stream().allMatch((x) -> x > 0);
        boolean b3 = nums.stream().noneMatch((x) -> x < 0);
        System.out.println(b1+ " " +b2+ " " +b3);


        //6. findfirst, findany

        System.out.println(nums.stream().findAny().get());
        System.out.println(nums.stream().findFirst().get());


        //7. toArray
        Object[] array = Stream.of(1,2,3,4).toArray();


        //8. MAX/MIN

        System.out.println("Max of the list: " +Stream.of(1,2,3,4,5).max((a,b) -> a -b).get()); //beacuse it is coming optional we have to use get
        System.out.println("Min of the list: "+Stream.of(1,2,3,4,5).min(Comparator.naturalOrder()));


        //9. flatmap
        //Handle streams of collections, lists, or arrays where each element is itself a colleciton
        //flatten nested structures (e.g lists within lists) so that they can be processes as a single sequence of elementw
        // transform and flatten elements at the same time.

        List<List<String>> lisoflist = Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("orange","kiwi"),
                Arrays.asList("pear","grape")
        );


        //if you have to get an element inside the list of lists
        //indexes will go 0,1,2
        System.out.println(lisoflist.get(2).get(1));

        System.out.println(lisoflist.stream().flatMap(x -> x.stream()).map(x -> x.toUpperCase()).toList());

        List<String> sentence = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatmap is useful"
        );

        System.out.println(sentence
                .stream()
                .flatMap((x) -> Arrays.stream(x.split(" ")))
                .map(String::toUpperCase)
                .toList());



        //10. foreachordered

        List<Integer> nums3 = Arrays.asList(1,2,3,4,54,5,6,7,8);
        System.out.println("without foreach ordered");
        nums3.parallelStream().forEach(System.out::println);
        System.out.println("with foreach ordered");
        nums3.parallelStream().forEachOrdered(System.out::println);




        //example

        //Streams can not be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);

        //List<String> list2 = stream.map(String::toUpperCase).toList();  //exception



        //counting occurance of character
        String txt = "Hello World";
        System.out.println(txt.chars().filter((x) -> x == 'l').count());


        //example
        List<String> list1 = Arrays.asList("Apple","banana","Kiwi");

        System.out.println(list1.stream().sorted((a,b) -> b.length() - a.length()).toList());

        String text = "Hi This is this is one string string string";
        Map<String,Long> wordFreq = Stream.of(text.split("\\s+")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        wordFreq.forEach((word, frequency) ->
                System.out.println(word+ " :" +frequency));

    }
}
