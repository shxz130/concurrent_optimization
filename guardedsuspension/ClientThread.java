package com.shxz.guardedsuspension;

import java.util.Random;

public class ClientThread extends Thread {
    private Random random;
    private RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " ËÍ³öÇëÇó " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
            }
        }
    }
}