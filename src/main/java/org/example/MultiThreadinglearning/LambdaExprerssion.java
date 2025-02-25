package org.example.MultiThreadinglearning;

public class LambdaExprerssion {
    public static void main(String[] args) {

        //functional interface
        //runnnable
        //Runnable runnable = () -> System.out.println("Hello");


        Thread t1 = new Thread(() -> System.out.println("Hello"));
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World");
            }
        });
        int a =1;
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello World");
            }
        };


        t1.start();
    }
}
