package com.wei.collection.demo1;


import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by weiguangjian on 2017/2/4.
 */
public class Main {

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[100];

        for(int i=0;i<100;i++){
            AddTask addTask = new AddTask(list);
            threads[i] = new Thread(addTask);
            threads[i].start();
        }

        System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);

        for(int i=0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: size of the list : %d\n",list.size());

        for(int i=0;i<threads.length;i++){
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);

        for(int i=0;i<threads.length;i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: Size of the List:%d\n",list.size());

    }
}
