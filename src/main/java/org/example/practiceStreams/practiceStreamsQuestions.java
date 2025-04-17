package org.example.practiceStreams;



import com.sun.jdi.IncompatibleThreadStateException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class practiceStreamsQuestions {
    public static void main(String[] args) {
        //find all evennumbers from a list
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> res = list.stream().filter((x) -> x % 2 == 0).toList();
        System.out.println(res);

        //summing numbers in a list
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        Optional<Integer> sum = list1.stream().reduce((x, y) -> x + y);
        System.out.println(sum.get());


        //create a stream from a collection, array, file





        //sorting with streams
        //sorting integers
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println(list2);
        List<Integer> sortingdes = list2.stream().sorted((x, y) -> y - x).toList();
        System.out.println(sortingdes);

        //sorting string
        List<String> list3 = new ArrayList<>();
        list3.add("apple");
        list3.add("kiwi");
        list3.add("banana");
        list3.add("pineapple");
        list3.add("mango");
        List<String> sortstr = list3.stream().sorted((x, y) -> y.length() - x.length()).toList();

        //List<String> sortstr = list3.stream().sorted().toList().reversed();
        //List<String> sortstr = list3.stream().sorted().toList();
        //List<String> sortstr = list3.stream().sorted((x, y) -> x.length() - y.length()).toList();
        System.out.println(sortstr);



        //flatmap a list of list into a single list
        List<List<Integer>> list4 = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );
        System.out.println(list4.get(1).get(2));
        List<Integer> flatmap = list4.stream().flatMap(x -> x.stream()).toList();
        System.out.println(flatmap);
        System.out.println(flatmap.reversed());


        //flatmap of string
        List<List<String>> list5 = Arrays.asList(
                Arrays.asList("apple","kiwi"),
                Arrays.asList("pineapple","banana"),
                Arrays.asList("mango","grapes")
        );
        System.out.println(list5.get(1).get(0));
        List<String> flatmapstring = list5.stream().flatMap(x -> x.stream()).toList();
        System.out.println(flatmapstring);
        System.out.println(flatmapstring.reversed());
        System.out.println(flatmapstring.stream().sorted((x,y) -> x.length() - y.length()).toList().reversed());
        System.out.println(flatmapstring.stream().sorted().toList());




        //grouping by department
        List<Emp> emp = Arrays.asList(
                new Emp("Shubham","Engineering"),
                new Emp("Ankit","Engineering"),
                new Emp("Atul","Analyst"),
                new Emp("Neha","HR"),
                new Emp("Akshit","Sales")
        );
        System.out.println( emp.stream()
                .collect(Collectors
                        .groupingBy(x -> x.dept, Collectors
                                .toList())));




        //joining string
        List<String> list6 = Arrays.asList("apple","grapes","banana");
        String collect = list6.stream().collect(Collectors.joining(", "));
        System.out.println(collect);

        //Top N Problem
        List<Stu> list7 = Arrays.asList(
                new Stu("Ankit",91),
                new Stu("Shubham",99),
                new Stu("David",79),
                new Stu("Bob",97),
                new Stu("Charlie",88)

        );

        List<Stu> topNElement = list7.stream()
                .sorted((x, y) -> y.marks - x.marks)
                .limit(3)
                .toList();
        System.out.println("Top 3 students: " +topNElement);


        //find char freq
        String name = "Ankit";
        System.out.println(name.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting())));



        List<String> list8 = Arrays.asList("ankit","atul","akshit");
        System.out.println(list8.stream().map(x -> x.toUpperCase()).toList());



        //how to find the longest string in a list
        List<String> list9= Arrays.asList("apple","pineapple","banana","kiwi");
        System.out.println(list9.stream().max((x,y) -> Integer.compare(x.length(),y.length())).orElse("No String"));


        //count the number of element in a list
        List<String> list10 = Arrays.asList("apple","kiwi","pineapple");
        System.out.println( list10.stream().collect(Collectors.counting()));



        //count even numbers in a list
        List<Integer> list11 = Arrays.asList(1,2,3,4,5,6);
        System.out.println(list11.stream().filter(x -> x%2 ==0).toList());


        int[] arr2 = {1,2,3,4,5};
        System.out.println( Arrays.stream(arr2).sum());



        //list of unique characters from a string array
        String[] str = {"Hello","World"};
//        System.out.println(Arrays.stream(str)
//                        .flatMap(x -> x.chars().mapToObj(c -> (char) c)).collect(Collectors.toSet()));
        System.out.println(Arrays.stream(str)
                .flatMap(x -> x.chars().mapToObj(c -> (char) c)).collect(Collectors.groupingBy(x -> x, Collectors.counting())));




        //find first non empty String in a list
        List<String> list12 = Arrays.asList(""," ","Hello","world");
//        System.out.println(list12.stream().filter(x -> !x.trim().isEmpty()).findFirst().orElse("None"));
        System.out.println(list12.stream().filter(x -> !x.trim().isEmpty()).findAny().orElse("None"));


        //partition into even and odd
        List<Integer> list13 = Arrays.asList(1,2,3,4,5,6,7,8);
        Map<Boolean, List<Integer>> evenodd = list13.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList()));
        System.out.println("Even: " +evenodd.get(true));
        System.out.println("odd: " +evenodd.get(false));




        //concatenating multiple string using streams
        String str2 = Stream.of("Hi","Java","8 is fun").collect(Collectors.joining(" "));
        System.out.println(str2);


        //how to find the longest string in a list
        List<String> list14 = Arrays.asList("apple","pineapple","banana","kiwi");
        System.out.println(list14.stream().max((x,y) -> Integer.compare(x.length(),y.length())).orElse("No string"));



        //        APPL_Unitrax | Role_Admin | APPL_WL
//        Output : Admin
        String word = "APPL_Unitrax | Role_Admin | APPL_WL";
        System.out.println(Arrays.stream(word.split("[|]"))
                        .map(x -> x.trim())
                .filter(x -> x.contains("Role_"))
                .map(x -> x.replace("Role_", ""))
                .toList());



        String input = "Hello world ! Hello, Java";
        System.out.println(Arrays.stream(input.split("[\\W]+"))
                        .map(x -> x.trim())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())));




        String text = "Hi This is this is one string string string";
        System.out.println(Arrays.stream(text.split("\\s+"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())));



        List<String> sentence = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatmap is useful"
        );
        System.out.println(sentence.stream().flatMap(x -> Arrays.stream(x.split(" "))).toList());



        //2. squaring and sorting numbers
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        System.out.println(nums.stream().map(x -> x*x).toList());


        //5.summarizing data
        //generates statistical summary (count,sum,min, average,max)

        List<Integer> nums1 = Arrays.asList(2,3,5,7,9);
        System.out.println(nums1.stream().collect(Collectors.summarizingInt(x -> x)));

        //6. creating a map from stream elements
        List<String> fruits  = Arrays.asList("Apple","Banana","Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(),x -> x.length())));




        List<Empl> employees = Arrays.asList(
                new Empl("Alice","HR",10000),
                new Empl("Bob","Engineering",20000),
                new Empl("Charlie","HR",500000),
                new Empl("David","Engineering",2000),
                new Empl("Eve","Sales",500),
                new Empl("Florida","Sales",500)


        );


        //grouping employees by department
        Map<String, Long> group = employees.stream().collect(Collectors.groupingBy(x -> x.department, Collectors.counting()));
        Map<String, Map<Integer, Long>> group2 = employees.stream()
                .collect(Collectors
                        .groupingBy(x -> x.department, Collectors.groupingBy(x -> x.salary ,Collectors.counting())));


        List<Empl> compare = employees.stream()
                .sorted((x, y) -> y.department.length() - x.department.length())
                .sorted((x, y) -> y.salary - x.salary)
                .toList();


        System.out.println("sorted by department then salary in descending order: " +compare);


        System.out.println(group2);
        System.out.println(group);


    }
}

class Emp{
    String name;
    String dept;


    @Override
    public String toString() {
        return name;
    }


    public Emp(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }
}

class Stu{
    String name;
    int marks;

    public Stu(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }


    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}


class Empl{
    String name;
    String department;
    int salary;


    public Empl(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Empl{" +
                "name='" + name + '\'' +
                ", dept='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
