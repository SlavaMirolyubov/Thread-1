package com.Threads;

import com.Main;
import com.service.MyQueue;

public class Booker extends Thread {

    private MyQueue queue;

    private final static int NUMBER_OF_REQUEST = Main.NUMBER_OF_REQUEST;

    public Booker(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (MyQueue.numberOfRequest.get() != NUMBER_OF_REQUEST) {
            queue.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }
}
