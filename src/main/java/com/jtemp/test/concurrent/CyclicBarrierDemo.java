package com.jtemp.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(6, () -> System.out.println("所有运动员入场，裁判一声令下"));


        System.out.println("运动员准备进场，全场欢呼。。。");

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 进场");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " 出发");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            });
        }

    }

}
