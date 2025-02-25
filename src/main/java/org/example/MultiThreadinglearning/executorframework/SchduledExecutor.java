package org.example.MultiThreadinglearning.executorframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchduledExecutor {
    public static void main(String[] args) {


        ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);

//        schedular.schedule(
//                () -> System.out.println("Task executed after 5 seconds delay!"),
//                5, TimeUnit.SECONDS);
//        schedular.shutdown();


        schedular.scheduleAtFixedRate(
                () -> System.out.println("Task executed after every 5 seconds !"),
                5,
                5,
                TimeUnit.SECONDS
        );

        schedular.schedule(() ->{
            System.out.println("Initializing shutdown...");
            schedular.shutdown();
        },20,TimeUnit.SECONDS);


        ScheduledFuture<?> scheduledFuture = schedular.scheduleWithFixedDelay(
                () -> System.out.println("Task executed after every 5 seconds !"),
                5,
                5,
                TimeUnit.SECONDS
        );

        //scheduledFuture.
        //several ,methods


    }
}
