package org.example.interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java_and_MultiThreading {
    public static void main(String[] args) {
        List<Emple> list = new ArrayList<>();
        list.add(new Emple(1,"Ankit",10000,28));
        list.add(new Emple(5,"Atul",15000,23));
        list.add(new Emple(4,"Bob",21000,22));
        list.add(new Emple(4,"Charlie",30000,25));
        list.add(new Emple(5, "Bob",25000,19));
        System.out.println(list);
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(x -> x.name, Collectors.counting()));
        Map<Integer, Long> collect1 = list.stream().collect(Collectors.groupingBy(x -> x.id, Collectors.counting()));

        System.out.println(collect);
        System.out.println(collect1);

        //filter out employee with age>20 and salary < 20000
        List<Emple> list1 = list.stream().filter(x -> x.age > 20 && x.salary < 20000).toList();
        System.out.println(list1);


        String str = "This is is a java program which is java";
        String ss = "Ankit";
        Map<String, Long> collect2 = Arrays.asList(str.split(" "))
                .stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect2);
        System.out.println(str.intern() == ss);







    }
}


class Emple implements Comparable<Emple>{

    int id;
    String name;
    int salary;
    int age;

    public Emple(int id, String name, int salary, int age){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public int compareTo(Emple other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Emple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
