package com.jtemp.test.collection;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 最小的 K 个数
 */
public class Demo14 {

    public static void main(String[] args) {

        int[] array = initArray();
        System.out.println(IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.toList()));

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int k = 10;

        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(queue);


    }

    private static int[] initArray() {
        int len = 20;
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(100);
        }
        return array;
    }

}
