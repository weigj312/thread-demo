package com.wei.collection.demo3;

/**
 * Created by weiguangjian on 2017/2/4.
 */
public class Event implements Comparable<Event> {

    private int thread;
    private int priority;

    public Event(int thread, int priority) {
        this.thread = thread;
        this.priority = priority;
    }

    @Override
    public int compareTo(Event o) {
        if(this.priority > o.getPriority()){
            return -1;
        }else if(this.priority < o.getPriority()){
            return 1;
        }

        return 0;
    }

    public int getThread() {
        return thread;
    }

    public int getPriority() {
        return priority;
    }
}
