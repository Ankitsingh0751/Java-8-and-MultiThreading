package org.example.MultiThreadinglearning.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);







        for(int i= 1;i<10;i++){
            int finalI = i;
            Future<?> future = executor.submit(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    });

        }
        executor.shutdown();
        //executor.shutdownNow();


        //one method(concept)
//        try {
//            while(!executor.awaitTermination(10, TimeUnit.MILLISECONDS)){
//                System.out.println("Waiting....");
//            }
//
//
//            //executor.awaitTermination(100, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Total time: " +(System.currentTimeMillis() - startTime));
//


        //2nd concept
        //Thread[] threads = new Thread[9];

//        for (int i = 1; i < 10; i++) {
//            int finalI = i;
//            threads[i-1] = new Thread(
//                    () -> {
//                        long result = factorial(finalI);
//                        System.out.println(result);
//                    });
//            threads[i-1].start();
//        }
//
//        for(Thread thread : threads){
//            try{
//                thread.join();
//            }catch (InterruptedException e){
//                Thread.currentThread().interrupt();
//            }
//        }
//        System.out.println("Total time: " +(System.currentTimeMillis() - startTime));
    }


    // 5 = 5.4.3.2.1


    private static long factorial(int n ){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *=i;
        }
        return result;
    }




}
