package org.example.MultiThreadinglearning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "atempting to withdraw" + amount);


        //extrinsic lock
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount){
                    try{
                        System.out.println(Thread.currentThread().getName() + "proceeding with withdrawal");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()+ "Withdrawal completed. Remaining balance: " +balance);

                    }catch(Exception e) {
                            Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }

                }else{
                    System.out.println(Thread.currentThread().getName()+ "insufficient balance");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+ "Could not acquire the lock, will try later");
            }
        } catch (Exception e) {
                Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("further implementation");
        }


//        if (balance >= amount) {
//            System.out.println(Thread.currentThread().getName() + "proceeding with withdrawal");
//

//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName()+ "Withdrawal completed. Remaining balance: " +balance);
//
//        }else{
//            System.out.println(Thread.currentThread().getName()+ "insufficient balance");
//        }
//


//        }
    }
}
