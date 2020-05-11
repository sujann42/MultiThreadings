package com.threads.deadlock;

public class AppMain1 {

    public static void main(String[] args) throws InterruptedException {
        DeadlockRunner1 runner = new DeadlockRunner1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        runner.finished();
    }

}
