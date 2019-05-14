package com.service;

import com.Entity.Request;
import com.Main;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    private LinkedList<Request> queue = new LinkedList<>();

    private volatile int queueSize = 0;

    public static AtomicInteger numberOfRequest = new AtomicInteger(0);

    private static Logger logger = Logger.getLogger(MyQueue.class);

    public synchronized void pushToQueue(Request request) {

        while (queue.size() >= Main.SIZE_OF_QUEUE) {
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
        notify();
    }

    public synchronized void get() {
        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.size();
        queue.getLast();
        queueSize--;
        queue.remove(queue.getLast());
        numberOfRequest.incrementAndGet();
        logger.info("Запрос обработан");
        logger.info("Элементов в очереди: " + queueSize);
        logger.info("Элементы в очереди" + queue);
        notify();
    }
}
