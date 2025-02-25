package org.example.collectionframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {

    public static void main(String[] args) {

        //A type of stream that enables parallel processing of element
        //Allowing multiple threads to process parts of the stream simultaneously
        //This can significantly improve performances for large data sets
        //workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x+1).limit(20000).toList();
        List<Long> factoriallist = list.stream().map(ParallelStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " +(endTime-startTime)+ " ms");


        startTime = System.currentTimeMillis();
        factoriallist = list.parallelStream().map(ParallelStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " +(endTime-startTime)+ " ms");

        //Parallel streams are most effective for cpu-intrensive or large datasets where tasks are independent
        //they may add overhead for simple tasks or small datasets



        //e.g  cumulative sum
        //{1,2,3,4,5} --> {1,3,6,10,15}
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativesum = nums.parallelStream().map(sum::addAndGet).toList();
        System.out.println("Expected cumulative sum: [1,3,6,10,15]");
        System.out.println("Actual cumulative sum: " +cumulativesum);

        //using streams instead of parallel streams will give right result
        //since the cumulative sum is dependent to one another its not independent
        //hence the ans will be random
//        List<Integer> cumulativesumstream = nums.stream().map(sum::addAndGet).toList();
//        System.out.println("Expected cumulative sum: [1,3,6,10,15]");
//        System.out.println("Actual cumulative sum: " +cumulativesumstream);



        //convert to sequential from parallel stream
//        List<Integer> cumulativesum2 = nums.parallelStream().map(sum::addAndGet).sequential().toList();
//        System.out.println("Expected cumulative sum: [1,3,6,10,15]");
//        System.out.println("Actual cumulative sum: " +cumulativesum);






    }

    private static long factorial(int n){
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
