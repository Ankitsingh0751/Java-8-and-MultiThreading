package org.example.CollectionsFramework;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DelayedTask> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedTask("Task1" , 5, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task2", 3, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task3", 10, TimeUnit.SECONDS));

        while(!delayQueue.isEmpty()){
            DelayedTask task = delayQueue.take(); //blocks unit a task's has expired
            System.out.println("Executed: " +task.getTaskName() + " at " +System.currentTimeMillis());
        }

    }

    static class DelayedTask implements Delayed {
        private final String taskName;
        private final long startTime;

        DelayedTask(String taskName, long delay, TimeUnit unit) {
            this.taskName = taskName;
            this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
        }


        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = startTime - System.currentTimeMillis();
            return unit.convert(remaining, TimeUnit.MICROSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.startTime < ((DelayedTask) o).startTime){
                return -1;
            }
            if(this.startTime > ((DelayedTask) o).startTime){
                return 1;
            }
            return 0;
        }

        public String getTaskName() {
            return taskName;
        }
    }
}
