package org.example.demo;

import jdk.dynalink.linker.LinkerServices;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

//        APPL_Unitrax | Role_Admin | APPL_WL
//        Output : Admin
        String word = "APPL_Unitrax | Role_Admin | APPL_WL";

        System.out.println(Arrays.stream(word.split("[|]"))
                        .map((x) -> x.trim())
                .filter((x) -> x.contains("Role_"))
                .map((x) -> x.replace("Role_",""))
                .toList());


        String input = "Hello world ! Hello, Java";
        System.out.println(Stream.of(input.split("[\\W]+"))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())));



    }
}
