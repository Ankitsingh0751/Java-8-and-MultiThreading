package org.example.MultiThreadinglearning;

public class Worldrunnable implements  Runnable{
    @Override
    public void run() {
        for(; ;){
            System.out.println("World");
        }
    }
}
