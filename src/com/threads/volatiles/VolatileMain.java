package com.threads.volatiles;

import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello from Sync..");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
    }
}

public class VolatileMain {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press Enter to stop!!!!");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        proc1.shutDown();

    }
}

