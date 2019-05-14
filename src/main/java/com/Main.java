package com;

import com.Threads.Booker;
import com.Threads.ThreadRequestGenerator;
import com.service.MyQueue;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {

    private final static int NUMBER_OF_THREADS = 3;
    public final static int NUMBER_OF_REQUEST = 15;
    private final static int NUMBER_OF_BOOKERS = 6;
    public final static int SIZE_OF_QUEUE = 5;

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        IntStream.range(0, NUMBER_OF_REQUEST)
                .forEach(x -> service.submit(new ThreadRequestGenerator(queue)));


        ExecutorService service2 = Executors.newFixedThreadPool(NUMBER_OF_BOOKERS);
        IntStream.range(0, NUMBER_OF_REQUEST)
                .forEach(x -> service2.submit(new Booker(queue)));

        service.shutdown();
        service2.shutdown();

        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
            service2.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
