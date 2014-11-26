package com.shxz.guardedsuspension;

import java.util.Random;

public class ServerThread extends Thread {
    private Random random;
    private RequestQueue requestQueue;
    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " ´¦Àí  " + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
            }
        }
    }
}