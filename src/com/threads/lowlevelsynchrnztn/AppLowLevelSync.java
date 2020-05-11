package com.threads.lowlevelsynchrnztn;

public class AppLowLevelSync {

    public static void main(String[] args) {
        final LowLevelProcessors processors = new LowLevelProcessors();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processors.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processors.consumer();
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

}
