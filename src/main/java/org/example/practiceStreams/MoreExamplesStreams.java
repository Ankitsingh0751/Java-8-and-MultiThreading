package org.example.practiceStreams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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



        //write code to move all 0's in the right side of list
        //list is having +ve,0,-ve integers.
        //also maintain the order of non zero integer's order
        List<Integer> list10 = Arrays.asList(1,0,-3,0,5,-2,0,8,0,-4);
        //output = [1,-3,5,-2,8,-4,0,0,0,0]
        List<Integer> list12 = Stream.concat(
                list10.stream().filter(x -> x != 0),
                list10.stream().filter(x -> x == 0)
        ).toList();
        System.out.println(list12);




        //How to find duplicate elements in a Stream in Java?
        List<Integer> duplicateelements = Arrays.asList(1,2,3,4,5,62,3,4);
        Set<Integer> collect = duplicateelements.stream()
                .filter(x -> Collections.frequency(duplicateelements, x) > 1)
                .collect(Collectors.toSet());
        System.out.println(collect);


        //Count occurrence of a given character in a string using Stream API in Java.



        // How to get Slice of a Stream in Java?
        List<Integer> list13 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> collect1 = list13.stream().skip(3).limit(7).toList();
        System.out.println(collect1);


        //How to Reverse elements of a Parallel Stream in Java?


        //find the longest string in a list
        List<String> list14 = Arrays.asList("apple","banana","pineapple","mango","kiwi");
        Optional<String> max = list14.stream()
                .max((x, y) -> Integer.compare(x.length(), y.length()));
        System.out.println("Element with max length: " +max.get());


        Optional<String> min = list14.stream()
                .min((x, y) -> Integer.compare(x.length(), y.length()));
        System.out.println("Element with min length: " +min.get());



        //Calculate the average age of a list of Person objects using Java streams:
        List<Person> personList = Arrays.asList(
                new Person("Ankit",24),
                new Person("Bob",34),
                new Person("Charlie",41)
        );
        double average = personList.stream()
                .mapToInt(x -> x.age).average().orElse(0);
        System.out.println(average);



        //check if the number is prime or not
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean containprime = numbers.stream()
                .anyMatch(number -> isPrime(number));
        System.out.println("List that contains prime: " +containprime);


        //Merge two sorted lists into a single sorted list using Java streams
        List<Integer> merge1 = Arrays.asList(1,2,3,4,5);
        List<Integer> merge2 = Arrays.asList(9,7,6);
        List<Integer> sortedmerge = Stream.concat(merge1.stream(), merge2.stream()).sorted().toList();
        System.out.println(sortedmerge);


        //intersect element
        List<Integer> intersect1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> intersect2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersectingelement = intersect1.stream()
                .filter(intersect2::contains)
                .toList();
        System.out.println(intersectingelement);


        //Remove duplicates from a list while preserving the order using Java streams
        List<Integer> deuplicates = Arrays.asList(1,2,3,4,3,2,4,5,6,7);
        List<Integer> dupeelement = deuplicates.stream().distinct().toList();
        System.out.println(dupeelement);


        //Given a list of transactions, find the sum of transaction amounts for each day using Java streams
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        Map<String, Integer> summingtransac = transactions.stream()
                .collect(Collectors.groupingBy(x -> x.date, Collectors.summingInt(x -> x.price)));

        System.out.println(summingtransac);

        //Find the kth smallest element in an array using Java streams
        List<Integer> kthsmallest = Arrays.asList(6,5,4,3,2,1);
        int k = 3;
        Integer kthsmall = kthsmallest.stream()
                .sorted()
                .skip(k - 1)
                .findFirst().orElse(-1);
        System.out.println(kthsmall);




        //Given a list of strings, find the frequency of each word using Java streams
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> wordfreq = words.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(wordfreq);


        //Implement a method to partition a list into two groups based on a predicate using Java streams

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partelements = numbers1.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Even numbers: " +partelements.get(true));
        System.out.println("Odd numbers: " +partelements.get(false));


        //print fibbonacci series
        LongStream fibonacci = Stream.iterate(
                        new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .mapToLong(f -> f[0]);
        // Print first 10 Fibonacci numbers
        fibonacci.limit(10).forEach(System.out::println);



        //Find the median of a list of integers using Java streams:
//        List<Integer> numbers2 = Arrays.asList(5, 2, 1, 3, 4);
//        OptionalDouble median = numbers2.stream()
//                .sorted()
//                .mapToInt(Integer::intValue)
//                .collect(IntStream.)
//                .getMedian();
//        System.out.println("Median: " + median.getAsDouble());


        //Given a list of strings, find the longest common prefix using Java streamsGiven a list of strings, find the longest common prefix using Java streams
        List<String> strings = Arrays.asList("flower", "flow", "flight");
        String longestCommonPrefix = strings.stream()
                .reduce((s1, s2) -> {
                    int length = Math.min(s1.length(), s2.length());
                    int i = 0;
                    while (i < length && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");
        System.out.println("Longest common prefix: " + longestCommonPrefix);



        //Find the maximum product of two integers in an array using Java streams
        int[] array = {1, 7, 3, 6, 2, 4, 8};
        int maxProduct = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);
        System.out.println("Maximum product: " + maxProduct);


        //Implement a method to find all anagrams in a list of strings using Java streams
        List<String> words1 = Arrays.asList("listen", "silent", "hello",
                "world", "night", "thing");
        Map<String, List<String>> anagrams = words1.stream()
                .collect(Collectors.groupingBy(str1 -> {
                    char[] chars = str1.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        System.out.println("Anagrams: " + anagrams);


//        //Given a list of intervals, find the total covered length using Java streams
//        List<Interval> intervals = Arrays.asList(new Interval(1, 3),
//                new Interval(5, 8), new Interval(10, 12));
//        int totalCoveredLength = intervals.stream()
//                .mapToInt(interval -> interval.getEnd() - interval.getStart())
//                .sum();
//        System.out.println("Total covered length: " + totalCoveredLength);


        //Find the number of occurrences of a given character in a list of strings using Java streams
        List<String> strings1 = Arrays.asList("apple", "banana", "orange",
                "grape", "melon");
        char target = 'a';
        long occurrences = strings1.stream()
                .flatMapToInt(CharSequence::chars)
                .filter(c -> c == target)
                .count();
        System.out.println("Occurrences of '" + target + "': " + occurrences);



        //Given a list of integers, find all pairs of numbers that sum up to a given target using Java streams
        List<Integer> numbers3 = Arrays.asList(2, 4, 6, 8, 10);
        int target1 = 12;
        Set<String> pairs = numbers3.stream()
                .flatMap(i -> numbers3.stream().
                        map(j -> i + j == target1 ? "(" + i + ", " + j + ")" : ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
        System.out.println("Pairs that sum up to " + target1 + ": " + pairs);



        //Given a list of integers, find all non duplicate integers using Java streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);

// Count the occurrences of each number
        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())
                );

// Filter out non-duplicate numbers
        numbers.stream()
                .filter(number -> frequencyMap.get(number) == 1)
                .forEach(System.out::println);




    }



    public static boolean isPrime(int number){
        if(number <=1){
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }



}




class Person{
    String name;
    int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Transaction{
    String date;
    int price;

    public Transaction(String date, int price) {
        this.date = date;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}

class Interval{
    int id1;
    int id2;

    public Interval(int id1, int id2) {
        this.id1 = id1;
        this.id2 = id2;
    }


}

