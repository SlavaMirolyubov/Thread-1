package com.Threads;

import com.Entity.Request;
import com.service.MyQueue;
import com.service.RequestGenerator;

public class ThreadRequestGenerator implements Runnable  {

    private MyQueue queue;

    public ThreadRequestGenerator(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        RequestGenerator requestGenerator = new RequestGenerator();
        Request request = requestGenerator.generateRandomRequest();
        queue.pushToQueue(request);
    }
}
