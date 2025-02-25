package org.example.collectionframework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + department+ " " +salary;
    }
}

class GroupbyDept{
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR",10000),
                new Employee("Bob","Engineering",20000),
                new Employee("Charlie","HR",500000),
                new Employee("David","Engineering",2000),
                new Employee("Eve","Sales",500)


        );


        //grouping employees by department
        Map<String, List<Employee>> res = employees.stream().collect(Collectors.groupingBy(x -> x.department, Collectors.toList()));
        System.out.println("Grouped by department: " +res);

        //sort by name then salary
//        List<Employee> sortedemployee = employees
//                .stream()
//                .sorted((a,b) -> a.name.length() - b.name.length())
//
//                .collect(Collectors.toList());
//
//        System.out.println(sortedemployee);



    }
}