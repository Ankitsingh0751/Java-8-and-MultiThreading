package org.example.collectionframework;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class intermidateOperations {

    public static void main(String[] args) {
        //intermideate operations tranform a stream into another stream
        //they are lazy, meaning they dont execute until a terminal operation is invoked


        //1.filter
        List<String> list = Arrays.asList("Akshit","Ram","Shyam","Ghanshyam","Akshit");
        Stream<String> filerstream = list.stream().filter((x) -> x.startsWith("A"));
        //no filtering till this point
        long res = list.stream().filter((x) -> x.startsWith("A")).count();
        System.out.println(res);

        //2.map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        //3.sorted
        Stream<String> sortedstream = list.stream().sorted();
        Stream<String> sortedstreamusingcomparator = list.stream().sorted((a,b) -> a.length() - b.length());

        //4.distinct
        System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

        //5. limit
        Stream.iterate(1, x->x+1).limit(100).count();


        //6.skip
        Stream.iterate(1, x->x+1).limit(100).skip(10).count();

        //7. peek
        Stream.iterate(1, x -> x+1).skip(10).limit(100).peek(System.out::println).count();


        //8.



    }


}

