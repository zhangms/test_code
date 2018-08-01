package com.jtemp.test.demo;

public class GameObject {


    static Object lock = new Object();

    static volatile boolean ret = false;

    static class Printer extends Thread {

        @Override
        public void run() {
            while (true) {

                System.out.println("before lock");
                synchronized (lock) {
                    try {
                        System.out.println("locked");
                        if (!ret) {
                            System.out.println("wait before");
                            lock.wait();
                            System.out.println("wait after");
                        }
                        System.out.println("----hello-->" + ret);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                ret = !ret;
                lock.notifyAll();
            }
        }
    }

}
