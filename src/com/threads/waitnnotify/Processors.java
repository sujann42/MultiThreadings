package com.threads.waitnnotify;

import java.util.Scanner;

public class Processors {
    public void producer() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread running!!!");
            wait(); //waits -- can be only called within synchronized block.
            System.out.println("Resumed.");
        }
    }
    public void consumer() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("Waiting for return key.");
            sc.nextLine();
            System.out.println("Return key pressed.");
            notify(); //notifies -- can be only called within synchronized block.
        }
    }
}
