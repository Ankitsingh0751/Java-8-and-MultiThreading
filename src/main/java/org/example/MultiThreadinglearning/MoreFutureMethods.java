package org.example.MultiThreadinglearning;

import java.util.concurrent.*;

public class MoreFutureMethods {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Eception occurred: " +e);
            }
            System.out.println("Hello");
            return 42;
        });

//

//        submit.cancel(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exsception occurred: " +e);
        }
        submit.cancel(false);
        System.out.println(submit.isCancelled());
        System.out.println(submit.isDone());

        executorService.shutdown();
    }
}
