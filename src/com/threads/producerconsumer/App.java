package com.threads.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    //This is thread safe. We can access data from any thread safe without worries.
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    static Random random = new Random();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //This will produce data to be consumed by other threads.
    private static void producer() throws InterruptedException {
        while (true){
            queue.put(random.nextInt(100));
        }
    }
    private static void consumer() throws InterruptedException {
        while (true){
            Thread.sleep(100);
            if(random.nextInt(10) == 0){
                int value = queue.take();
                System.out.println("Taken value is: "+ value+" "+"Queue size is: "+queue.size());
            }
        }
    }
}
