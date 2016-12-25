package com.wei.helper.semaphore2;

/**
 * Created by WEI on 2016/12/25.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        System.out.printf("%s:going to print a job\n",Thread.currentThread().getName());
        printQueue.printJob();
        System.out.printf("%s: the document has been printed\n",Thread.currentThread().getName());
    }
}
