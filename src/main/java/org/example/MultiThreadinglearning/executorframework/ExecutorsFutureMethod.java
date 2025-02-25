package org.example.MultiThreadinglearning.executorframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsFutureMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> callable = () -> "Hello";
//        Future<String> future = executorService.submit(callable);
//
//
//        //Future<String> future = executorService.submit(() -> "Hello");
//
//        System.out.println(future.get()); // waits to get the task done
////        if(future.isDone()){
////            System.out.println("Task is done...");
////        }
//        executorService.shutdown();
//
//        //Future<String> submit = executorService.submit(() -> System.out.println("Hello"), "success");



        ExecutorService executorService = Executors.newFixedThreadPool(2);



            //concept
//        Future<Integer> submit = executorService.submit(() -> 1 + 2);
//        Integer i = submit.get();
//        System.out.println("Sum is: " +i);
//        executorService.shutdown();
////        System.out.println(executorService.isShutdown());
//        Thread.sleep(1);
//        System.out.println(executorService.isTerminated()); //if all the tasks are shutdown


        //concept
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };



        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = executorService.invokeAll(list);

        for(Future<Integer> f : futures){
            System.out.println(f.get());
        }

        executorService.shutdown();

        System.out.println("Hello");


    }
}
