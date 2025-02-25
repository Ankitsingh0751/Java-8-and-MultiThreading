package org.example.MultiThreadinglearning;

public class Test {
    public static void main(String[] args) {
//        System.out.println("Hello World");
//        System.out.println(Thread.currentThread().getName());

//        World world = new World();
//        world.start();
//        Worldrunnable worldrunnable = new Worldrunnable();   //new state
//        Thread t1 = new Thread(worldrunnable);
//        t1.start(); //runnable
//        for (; ;) {
//            System.out.println(Thread.currentThread().getName() );
//
//        }


        //vid-7

        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();

        }catch (Exception e){

        }
        System.out.println(counter.getCount());


    }
}
