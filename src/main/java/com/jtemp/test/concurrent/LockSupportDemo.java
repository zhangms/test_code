package com.jtemp.test.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            System.out.println("thread started");
            LockSupport.park();
            System.out.println("thread ended");
        });

        t.start();

        Thread.sleep(3000);
        LockSupport.unpark(t);


    }

}
