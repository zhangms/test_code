package com.jtemp.test.concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {


    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        ReentrantLock lock = new ReentrantLock();

        Condition notEmpty = lock.newCondition();

        Thread producer = new Thread(() -> {
            int i = 0;
            while (true) {
                lock.lock();
                try {
                    list.offer(i++);
                    notEmpty.signal();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        producer.setName("producer");

        Thread consumer = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    notEmpty.awaitUninterruptibly();
                    Integer val = list.poll();
                    while (val != null) {
                        System.out.println(val);
                        val = list.poll();
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        consumer.setName("consumer");

        producer.start();
        consumer.start();

    }

}
