package com;

import com.Threads.Booker;
import com.Threads.ThreadRequestGenerator;
import com.service.MyQueue;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {

    private static int NUMBER_OF_THREADS = 3;
    private static int NUMBER_OF_REQUEST = 15;

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        IntStream.range(0, NUMBER_OF_REQUEST)
                .forEach(x -> service.submit(new ThreadRequestGenerator(queue)));


        ExecutorService service2 = Executors.newFixedThreadPool(6);
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
