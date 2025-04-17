package org.example.interviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class questionsanswers {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> reduce = nums.stream().filter(x -> x % 2 == 0)
                .reduce((x, y) -> x + y);
        System.out.println(reduce.get());


    }
}

interface Student{
    default void run(){

    }
}