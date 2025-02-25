package org.example.collectionframework;

import java.lang.foreign.UnionLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Java8Features {
    public static void main(String[] args) {
        //streams

        //java 8 --> minimal code, functional programing,
        //java 8 --> lambda expression, Streams, Date & Time API



        //lambda expression is an anonymous function (no name, no return type, no access modifier)
        //lambda expression is used to implement functional interface

        Thread t = new Thread(
                () -> {
                    System.out.println("Hello");
                }
        );

        Mathoperation sumoperation = (a,b) -> a+b;
        Mathoperation subtract = (a,b) -> a-b;

        int res = sumoperation.operate(1,2);
        int res2 = subtract.operate(4,3);


        System.out.println(res);
        System.out.println(res2);



        //predicate --> functional interface (boolean valed function)
        //predicate se condition ko variable mein store kar rahe hain
        Predicate<Integer> isEven = x -> x%2 ==0;
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartingwithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndWith = x -> x.toLowerCase().endsWith("t");
        Predicate<String> and = isWordStartingwithA.and(isWordEndWith);
        System.out.println(and.test("Vipul"));


        //function
        //function having one only abstract but it will work something

        Function<Integer, Integer> doubleIt = x -> 2*x;
        Function<Integer, Integer> tripleIt = x -> 3*x;

        System.out.println(doubleIt.andThen(tripleIt).apply(20));
        System.out.println(doubleIt.compose(tripleIt).apply(20));

        //identity mein jo aap doge whi return ho jayga
        Function<Integer, Integer> identity = Function.identity();
        Integer res3 = identity.apply(5);
        System.out.println(res3);


        //Consumer
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(10);

        List<Integer> list = Arrays.asList(1,2,3,4);
        //System.out.println(list);
        Consumer<List<Integer>> print = x -> {
            for(int i : x){
                System.out.println(i);
            }
        };
        print.accept(list);


        //supplier
        //takes nothing just gives
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());

        //all together
        Predicate<Integer> predicate = x -> x %2 ==0;
        Function<Integer, Integer> function = x -> x*x;
        Consumer<Integer> consumer1 = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer1.accept(function.apply(supplier.get()));
        }


        //Bi Predicate, Biconsumer, Bifunction
        BiPredicate<Integer, Integer> issumeven = (x,y) -> (x+y) % 2 ==0;
        System.out.println(issumeven.test(3,3));

        BiConsumer<Integer, String> biconsumer2 = (x,y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String, String, Integer> bifunction2 = (x,y) -> (x+y).length();
        System.out.println(bifunction2.apply("ac", "cde"));

        //uninaryoperator, binaryoperator
        UnaryOperator<Integer> a = x -> 2*x;
        BinaryOperator<Integer> b = (x,y) -> x+y;


        //Method reference --> use method without invoking & in place of lambda expression

        List<String> students = Arrays.asList("Ankit","Hemu","Shyaam");
        students.forEach((x) -> System.out.println(x));
        students.forEach(System.out::println);

        //constructor reference
        List<String> names = Arrays.asList("A","B","C");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList());




    }
}

class MobilePhone{
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}

@FunctionalInterface
interface Mathoperation{
    int operate(int a , int b);
}