package org.example.MultiThreadinglearning;

public class MyThread extends Thread{


    //vid-7
    private Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    //creating constructor so that we can name the thread as per our need apart from
    //thread-0,thread-1 etc
//    public MyThread( String name){
//        super(name);
//    }


//    public  MyThread(String name){
//        super(name);
//    }

//    @Override
//    public void run() {
//
//
//        //daemon thread
//        while(true){
//            System.out.println("Hello world !");
//        }




//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName()+ " is running");
//            Thread.yield();
//        }




        //yield
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            System.out.println("Thread interrupted: " +e);
//        }



//        System.out.println("Thread is running...");
//        for(int i=1;i<5;i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }

//        for (int i = 0; i < 5; i++) {
//            String a = "";
//            for (int j =0;j< 100000000;j++){
//                a += "a";
//            }
//            System.out.println(Thread.currentThread().getName()+ " - Priority: " +Thread.currentThread().getPriority()+ " - count: " +i);
//
//            try{
//                Thread.sleep(100);
//            }catch (Exception e){
//
//            }
//        }

//    }


    //vid-4
//    @Override
//    public void run() {
//        System.out.println("RUNNING");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public static void main(String[] args) throws InterruptedException {









//        //daemon thread
//        MyThread myThread = new MyThread();
//        MyThread t1 = new MyThread();
//        myThread.setDaemon(true);
//        myThread.start();
//        t1.start();
//        System.out.println("Main done");





//        //yeild
//        MyThread t1 = new MyThread("t1");
//        MyThread t2 = new MyThread("t2");
//        t1.start();
//        t2.start();





//        //intrrupt
//         MyThread t1 = new MyThread();
//         t1.start();
//         t1.interrupt();


        //MyThread t1 = new MyThread("Ankit");
//        MyThread l = new MyThread("Low priority Thread");
//        MyThread m = new MyThread("Medium priority Thread");
//        MyThread h = new MyThread("High priority Thread");
//
//
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);
//        l.start();
//        m.start();
//        h.start();




//        t1.start();
//
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t1.join();
//        System.out.println("Hello");





        //vid -6
        //methods
        //start, run, sleep, join, setpriority, interrupt , yeild
        //daemon thread -> works in the background, does not wait for jvm
        //for user threads jvm waits to do the task it is meant to complete
        //then it terminates the thread but daemon thread's case
        //jvm does not wait for it to get completed



        //Vid-4
        //        MyThread t1 = new MyThread();
//        System.out.println(t1.getState());
//        t1.start();
//        System.out.println(t1.getState());
//        //System.out.println(Thread.currentThread().getState());
//        Thread.sleep(100);
//        System.out.println(t1.getState());
//        t1.join(); // main chala raha hai
//        System.out.println(t1.getState());

    }
}
