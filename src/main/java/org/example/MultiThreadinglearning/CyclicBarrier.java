//package org.example.MultiThreadinglearning;
//
//import java.util.concurrent.*;
//
//public class CyclicBarrier {
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int numberOfServices = 3;
//        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
//
//
//
//        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
//        executorService.submit(new DependentService(barrier));
//        executorService.submit(new DependentService(barrier));
//        executorService.submit(new DependentService(barrier));
//
//
//
//        System.out.println("Main");
//        executorService.shutdown();
//        barrier.
//
//
//
//    }
//
//
//}
//
//
//class DependentService implements Runnable{
//
//    private final CyclicBarrier barrier;
//
//    public DependentService(CyclicBarrier barrier){
//        this.barrier = barrier;
//
//    }
//
//
//    @Override
//    public void run() {
//        try{
//
//
//            System.out.println(Thread.currentThread().getName()+ " service started");
//            Thread.sleep(2000);
//            System.out.println(Thread.currentThread().getName()+ " waiting barrier");
//            barrier.wait();
//        }catch (Exception e){
//
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
//
//}
