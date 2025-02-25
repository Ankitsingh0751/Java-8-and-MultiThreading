//package org.example.MultiThreadinglearning;
//
//import java.util.concurrent.*;
//
//public class CountDownLatch {
//
//
//    public CountDownLatch(int numberOfServices) {
//
//    }
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int numberOfServices = 3;
//        // ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
//
////        Future<String> future1 = executorService.submit(new DependentService());
////        Future<String> future2 = executorService.submit(new DependentService());
////        Future<String> future3 = executorService.submit(new DependentService());
////
////
////        future1.get();
////        future2.get();
////        future3.get();
////
////        System.out.println("All services are finished. Starting main service...");
////        executorService.shutdown();
//
//        //countdown latch
//
////        CountDownLatch latch = new CountDownLatch(numberOfServices);
////        executorService.submit(new DependentService(latch));
////        executorService.submit(new DependentService(latch));
////        executorService.submit(new DependentService(latch));
////        latch.
////
////
////        System.out.println("Main");
////        executorService.shutdown();
//
//        //another method
//        CountDownLatch latch = new CountDownLatch(numberOfServices);
//        for (int i = 0; i < numberOfServices; i++) {
//            new Thread(new DependentService(latch)).start();
//        }
//        latch.wait(5);
//        System.out.println("Main");
//
//
//    }
//
//    public void countDown() {
//
//    }
//}
//
//
//class DependentService implements Runnable{
//
//    private final CountDownLatch latch;
//
//    public DependentService(CountDownLatch latch){
//        this.latch = latch;
//    }
//
//
//    @Override
//    public void run() {
//        try{
//            System.out.println(Thread.currentThread().getName()+ " service started");
//            Thread.sleep(2000);
//        }catch (Exception e){
//
//        }finally {
//            latch.countDown();
//        }
//    }
//}
//
//
////class DependentService implements Callable<String>{
////
////    private final CountDownLatch latch;
////
////    public DependentService(CountDownLatch latch){
////        this.latch = latch;
////    }
////
//////    @Override
//////    public String call() throws Exception {
//////        try{
//////            System.out.println(Thread.currentThread().getName()+ "service started.");
//////            Thread.sleep(2000);
//////        }finally {
//////            latch.countDown();
//////        }
//////        return "ok";
//////    }
////
////
//////    @Override
//////    public String call() throws Exception {
//////
//////        System.out.println(Thread.currentThread().getName() + " service started.");
//////        Thread.sleep(2000);
//////        return "ok";
//////    }
////}
