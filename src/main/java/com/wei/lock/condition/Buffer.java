package com.wei.lock.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by weiguangjian on 2016/12/16.
 */
public class Buffer {
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<String>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line){
        lock.lock();
        try{
            while(buffer.size() == maxSize){
                space.wait();
            }
            buffer.offer(line);
            System.out.printf("%s:inserted line:%d\n",Thread.currentThread().getName(),buffer.size());
            lines.signalAll();;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public String get(){
        String line = null;
        lock.lock();
        try{
            while ((buffer.size()==0) && (hasPedingLines())){
                lines.wait();
            }
            if(hasPedingLines()){
                line = buffer.poll();
                System.out.printf("%s:Line Readed:%d\n",Thread.currentThread().getName(),buffer.size());
            }
            space.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        return line;
    }

    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }

    public boolean hasPedingLines(){
        return pendingLines || buffer.size() >0;
    }

}
