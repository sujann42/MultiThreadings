package com.threads.semaphores;

public class Connection {
    private static Connection instance = new Connection();

    private Connection(){

    }
    public static Connection getInstance(){
        return instance;
    }
}
