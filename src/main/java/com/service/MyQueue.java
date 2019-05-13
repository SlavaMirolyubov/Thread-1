package com.service;

import com.Entity.Request;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    volatile LinkedList<Request> queue = new LinkedList<>();

    volatile int queueSize = 0;

    public static AtomicInteger numberOfRequest = new AtomicInteger(0);

    private static Logger logger = Logger.getLogger(MyQueue.class);

    public List<Request> getQueue() {
        return queue;
    }

    public synchronized void pushToQueue(Request request) {

        while (queue.size() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(request);
        queueSize++;
        logger.info("Запрос добавлен в очередь");
        logger.info("Элементов в очереди: " + queueSize);
        logger.info("Элементы в очереди" + queue);
        notifyAll();

    }

    public synchronized void get() {

        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (queue.size()>0) {
            queue.getLast();
            queueSize--;
            queue.remove(queue.getLast());
            numberOfRequest.incrementAndGet();
            logger.info("Запрос обработан");
            logger.info("Элементов в очереди: " + queueSize);
            logger.info("Элементы в очереди" + queue);
            notifyAll();

        }
    }
}
