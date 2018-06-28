package com.jtemp.test.collection;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Demo35 {

    static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("thread locked");
                if (true) {
                    throw new RuntimeException("ex");
                }
                lock.unlock();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 try lock");
                lock.lock();
                System.out.println("thread2 locked");
            }
        };

        t1.start();
        t2.start();

    }

}
