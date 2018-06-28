package com.jtemp.test.collection;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数 P。
 */
public class Demo25 {

    public static void main(String[] args) {
        int[] array = initArray(10);
        System.out.println(IntStream.of(array).boxed().collect(Collectors.toList()));
        int ret = findReverseCount(array, 1);
        System.out.println(ret);

    }

    private static int findReverseCount(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return 0;
        }
        int pre = array[index - 1];
        int now = array[index];
        int next = findReverseCount(array, index + 1);
        return pre > now ? 1 + next : next;
    }

    private static int[] initArray(int len) {
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = ThreadLocalRandom.current().nextInt(10) + 1;
        }
        return ret;
    }

}
