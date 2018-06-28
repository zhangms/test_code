package com.jtemp.test.concurrent;

public class DeadBlockDemo {


    static final Object a = new Object();
    static final Object b = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (a) {
                    synchronized (b) {
                        System.out.println("A->B");
                    }
                }
            }
        });

        thread.setName("A");

        Thread thread1 = new Thread(() -> {
            synchronized (b) {
                synchronized (a) {
                    System.out.println("B->A");
                }
            }
        });

        thread1.setName("B");

        thread.start();
        thread1.start();

    }


}
