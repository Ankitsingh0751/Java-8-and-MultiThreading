package org.example.collectionframework;

import java.io.File;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ExamplesDemo {
    public static void main(String[] args) {


        //find duplicates
        List<Integer> finduplicates = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 8, 9);

        System.out.println(finduplicates.stream()
                .filter(n -> Collections.frequency(finduplicates, n) > 1)
                .collect(Collectors.toSet()));


        //Fetching substring of a word from sentence
        String sentence = ("APPLUnitrax | RoleAdmin | APPLWL");
        List<String> word = Arrays.stream(sentence.split("[|]"))
                .map(String::trim)
                .filter((x) -> x.contains("Admin"))
                .map((x) -> x.replace("Role", ""))
                .collect(Collectors.toList());
        System.out.println(word);

        //even numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(list.stream().filter((x) -> x % 2 == 0).collect(Collectors.toList()));


        //creating stream from collection, array and file
        //collection
        List<Integer> collectionstream = Arrays.asList(1, 2, 3, 4, 5);
        collectionstream.forEach(System.out::println);

        //array
        int[] array = {1, 2, 3, 4, 5};
        IntStream streamfrommarray = Arrays.stream(array);
        streamfrommarray.forEach(System.out::println);

        //file
//        Stream<String> streamfromfile = Files.lines(Paths.get("sample.txt"));
//        streamfromfile.forEach(System.out::println);


        //summing numbers in list
        List<Integer> summingnums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(summingnums.stream().reduce((x, y) -> x + y).get());


        //sorting with stream
        List<Integer> sortingarray = Arrays.asList(5, 6, 3, 2, 1);
        System.out.println(sortingarray.stream().sorted().toList());


        List<String> sortingString = Arrays.asList("Apple", "Kiwi", "Banana");
        System.out.println(sortingString.stream().sorted((a, b) -> a.length() - b.length()).toList());


        //flatmap to flatten the list of list
        List<List<String>> flatstream = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Kiwi", "Grapes"),
                Arrays.asList("oranges", "mango")
        );

        System.out.println(flatstream.get(1).get(1));
        System.out.println(flatstream.stream().flatMap(Collection::stream).map(String::toUpperCase).toList());
        System.out.println(flatstream.stream().flatMap(Collection::stream).toList());


        //Grouping by department
        List<Student> students = Arrays.asList(
                new Student("Alice", "HR"),
                new Student("Bob", "Engineering"),
                new Student("Charlie", "HR"),
                new Student("David", "Sales")
        );

        Map<String, List<Student>> groupbyDept = students.stream()
                .collect(Collectors
                        .groupingBy((x) -> x.department));
        System.out.println("Group by dept: " + groupbyDept);


        //Joining Strings
        List<String> joinstring = Arrays.asList("Apple", "Kiwi", "Banana");
        System.out.println(joinstring.stream().collect(Collectors.joining(", ")));

        //top n element
        List<StudentMarks> studentmarks = Arrays.asList(
                new StudentMarks("Alice", 89),
                new StudentMarks("Bob", 55),
                new StudentMarks("Charlie", 37),
                new StudentMarks("David", 99),
                new StudentMarks("Eve", 100)

        );

        List<StudentMarks> res = studentmarks.stream().sorted((x, y) -> y.marks - x.marks).limit(3).toList();
        System.out.println("Top 3 students with highest marks: " + res);


        //frequency of each word in a string
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "kiwi", "banana", "apple", "orange", "apple");
        Map<String, Long> fruitscount = fruits.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("Freq count of each word: " + fruitscount);

        //frequency of each work in a sentence
        String freqword = "Hi this this is a a java colleciton this is simple is simple";
        Map<String, Long> freqcount = Stream.of(freqword.split("\\s+")).collect(Collectors.groupingBy(wow -> wow, Collectors.counting()));
        System.out.println("Frequency: " +freqcount);


//        freqcount.forEach((wow, freq) ->
//                System.out.println(wow + ": " + freq));



        //    String text = "Hi This is this is one string string string";
//        Map<String,Long> wordFreq = Stream.of(text.split("\\s+")).collect(Collectors.groupingBy(words -> words, Collectors.counting()));
//
//        wordFreq.forEach((words, frequency) ->
//                System.out.println(words+ " :" +frequency));


        //joining stream
        List<String> joinstreamsingle = Arrays.asList("apple", "kiwi", "banana");
        System.out.println(joinstreamsingle.stream().collect(Collectors.joining(" , ")));

        //word strip and print half word of a string
        String wordstrip = "AAple | AdminRole | DoingStuff";
        System.out.println(Arrays.stream(wordstrip.split("\\|"))
                        .map((x) -> x.trim())
                        .filter((x) -> x.contains("Stuff"))
                .map((x) -> x.replace("Doing", ""))
                        .toList()
                );

        //flatmap
        List<List<String>> flatmapex = Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("orange","kiwi"),
                Arrays.asList("Mango","Avacado")

        );

        List<String> exflat = flatmapex.stream().flatMap(List::stream).toList();
        System.out.println(exflat);



        //partioning by condition
        List<Integer> partint = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean, List<Integer>> partans = partint.stream().collect(Collectors.partitioningBy((x) -> x % 2 == 0, Collectors.toList()));
        System.out.println("Even: " +partans.get(true));
        System.out.println("Odd: " +partans.get(false));


        //to n element of a list
        List<Integer> topn = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(topn.stream().sorted((a,b) -> b-a).limit(3).toList());


        //find all the porduct in a single int from a list
        List<Integer> prod = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(prod.stream().reduce((x,y) -> x*y).get());


        //parallel stream summing of large numbers
        long summingparr = LongStream.rangeClosed(1,100000).parallel().sum();
        System.out.println(summingparr+ ": summing from parallel");


        //Pagination using skip and limit
        List<String> paginationsl = Arrays.asList("Alice","Bob","Charlie","David","Eve","Frank","Grace");
        int pagesize = 2;
        int pagenumber = 3; // 0-based

        List<String> respagination = paginationsl.stream()
                .skip(pagesize * pagenumber)
                .limit(pagesize)
                .toList();


        System.out.println("Pagingation names: " +respagination);



        //check if all the item in a list are even
        List<Integer>  evenlist = Arrays.asList(2,4,6,8,10);
        boolean b = evenlist.stream().allMatch((x) -> x % 2 == 0);
        System.out.println("Even numbers: " +b);

        List<Integer> oddoreven = Arrays.asList(1,2,3,4,5,6);
        boolean b1 = oddoreven.stream().anyMatch((x) -> x > 0);
        System.out.println(b1);

        List<Integer> numbersnonematch = Arrays.asList(1,2,3,4,5);
        boolean b2 = numbersnonematch.stream().noneMatch((x) -> x % 2 == 0);
        System.out.println(b2);



        List<Employees> emp = Arrays.asList(
                new Employees("Alice",20000),
                new Employees("Bob",10000),
                new Employees("Charlie", 50000),
                new Employees("David",30000)
        );

        //System.out.println(emp.get(3));
//        List<Employees> empres = emp.stream().sorted(Comparator.comparing(Employees::name).thenComparing(Employees::salary)).toList();
////        System.out.println(empres);

        Map<String, Integer> listtomap = emp.stream().collect(Collectors.toMap(e -> e.name, e -> e.salary));
        System.out.println(listtomap.keySet()+ " " +listtomap.values());


        //summarizing statistics
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        System.out.println(nums.stream().collect(Collectors.summarizingInt((x) -> x)));


        //grouping employee with dept and role
        List<CollegeEmp> college = Arrays.asList(
                new CollegeEmp("Alice","Engineering","Developer"),
                new CollegeEmp("Bob","Engineering","Developer"),
                new CollegeEmp("Charlie","HR","Manager"),
                new CollegeEmp("David","HR","Recruiter"),
                new CollegeEmp("Eve","Engineering","Tester")

        );

        Map<String, Map<String, List<CollegeEmp>>> groupingdeptroles = college.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.groupingBy(e -> e.role)));
        System.out.println("Grouping employee with dept and then roles: " +groupingdeptroles);


        //find first and last element
        List<Integer> element = Arrays.asList(1,2,3,4,5);
        Integer first = element.stream().findFirst().orElse(null);
        Integer last = element.stream().reduce((x, y) -> y).orElse(null);

        System.out.println("First: " +first);
        System.out.println("Last: " +last);



        List<String> stringelement = Arrays.asList("apple","kiwi","banana","orange","lichi");
        String firststring = stringelement.stream().findFirst().orElse(null);
        String lastelement = stringelement.stream().reduce((x, y) -> y).orElse(null);

        System.out.println("First element: " +firststring);
        System.out.println("Last element: " +lastelement);



        String sentence1 = ("APPLUnitrax | RoleAdmin | APPLWL");

        System.out.println(Arrays.stream(sentence1.split("[|]"))
                .map((x) -> x.trim())
                .filter((x) -> x.contains("Admin"))
                .map((x) -> x.replace("Role", ""))
                .toList());



        List<Integer> list9 = Arrays.asList(1,2,3,3,4,5,3,6,5);
        System.out.println(list9.stream().filter(n -> Collections.frequency(list9, n) > 1).sorted().toList());













    }


}


class Student {
    String name;
    String department;

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

class StudentMarks{
    String name;
    int marks;

    public StudentMarks(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}


class Employees{
    String name;
    int salary;

    public Employees(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return name+ " - " +salary;
    }
}

class CollegeEmp{
    String name;
    String department;
    String role;


    public CollegeEmp(String name, String role, String department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }

    @Override
    public String toString() {
        return "collegeEmp{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
