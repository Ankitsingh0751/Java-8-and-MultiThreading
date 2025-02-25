package org.example.MultiThreadinglearning;

public class Counter {
    private int count = 0;

    //only one will access at one time
    //if multiple threads are accessing a single object
//    public synchronized void increment(){
//        count++;
//    }

    //another thing we can do is to use synchronized keyword inside methods
    //so the block will be synchronized inside a method
    public  void increment(){
        synchronized (this){
            count++;
        }
    }


    public int getCount(){
        return count;
    }
}
