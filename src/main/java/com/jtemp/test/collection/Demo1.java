package com.jtemp.test.collection;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，
 * 也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为 7 的数组 {2, 3, 1, 0, 2, 5}，那么对应的输出是第一个重复的数字 2。
 * 要求复杂度为 O(N) + O(1)，也就是时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组
 */
public class Demo1 {


    public static void main(String[] args) {
        int[] array = {2, 2, 3, 2, 2};
        print(array);

        L:
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    System.out.println(array[i]);
                    break L;
                }
                swap(array, i);
            }
        }


    }

    private static void swap(int[] array, int i) {
        int val = array[i];
        int temp = array[val];
        array[val] = val;
        array[i] = temp;
    }

    private static void print(int[] array) {
        System.out.println(IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.toList()));
    }

    private static int[] createArray() {
        int len = ThreadLocalRandom.current().nextInt(10) + 10;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(len);
        }
        return array;
    }

}
