package com.threads.waystocreateThreads;


class RunnerExt extends Thread{
    public void run(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from extends! "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ExtendingThreadClass{
    public static void main(String[] args) {
        RunnerExt r1 = new RunnerExt();
        r1.start();

        RunnerExt r2 = new RunnerExt();
        r2.start();
    }

}
