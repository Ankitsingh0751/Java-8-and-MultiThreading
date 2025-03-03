package org.example.CollectionsFramework;

import java.util.Comparator;
import java.util.concurrent.*;


class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;


    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){

            try{
                System.out.println("Producer produced: " +value);
                queue.put(value++);
                Thread.sleep(1000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Produced interrupted");
            }
        }
    }
}



class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    private int value = 0;


    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while(true){

            try{
                Integer value = queue.take();
                System.out.println("Consumer produced: " +value);
                Thread.sleep(2000);
            }catch (Exception e){
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        }
    }
}







public class BlockingQueueExample {
    public static void main(String[] args) {
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
//
//        Thread producer = new Thread(new Producer(queue));
//        Thread consumer = new Thread(new Consumer(queue));
//        producer.start();
//        consumer.start();


        BlockingQueue<Integer> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<String> queue2 = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        queue2.add("apple");
        queue2.add("banana");
        queue2.add("cherry");
        System.out.println(queue2);









    }
}
