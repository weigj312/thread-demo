package com.wei.lock.lockfair;

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
        printQueue.printJob();
        System.out.printf("%s:the document has been printed\n",Thread.currentThread().getName());
    }
}
