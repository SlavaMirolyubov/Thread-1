package com.Threads;

import com.service.MyQueue;

public class Booker extends Thread {

    MyQueue queue;

    public Booker(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (MyQueue.numberOfRequest.get() != 15) {
            queue.get();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }
}
