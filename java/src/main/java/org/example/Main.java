package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int nThreads = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < (nThreads * 2); i++) {
            Runnable worker = () -> {
                System.out.println("Thread: " + Thread.currentThread().getName() + " running");
            };
            executorService.execute(worker);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {
            Thread.sleep(3_000);
            System.out.println("Waiting for all threads to finish...");
        }

        System.out.println("Finished all threads");
    }

}
