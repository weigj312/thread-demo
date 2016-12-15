package com.wei.lock;

/**
 * Created by weiguangjian on 2016/12/15.
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        System.out.printf("%s:going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s:the document has been printed\n",Thread.currentThread().getName());
    }
}
