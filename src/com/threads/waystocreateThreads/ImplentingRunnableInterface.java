package com.threads.waystocreateThreads;

class RunnersImp implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello from Implement "+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ImplentingRunnableInterface {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnersImp());
        Thread t2 = new Thread(new RunnersImp());

        t1.start();
        t2.start();

    }
}
