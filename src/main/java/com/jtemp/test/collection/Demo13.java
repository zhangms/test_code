package com.jtemp.test.collection;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
 * <p>
 * 使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。如果前面查找了 i 个元素，且 cnt == 0 ，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2 ，因为如果多于 i / 2 的话 cnt 就一定不会为 0 。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
 */
public class Demo13 {

    public static void main(String[] args) {
        int[] array = initArray();

        System.out.println(IntStream.of(array).mapToObj(String::valueOf).collect(Collectors.toList()));

        int major = array[0];
        int cnt = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == major) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                major = array[i];
                cnt = 1;
            }
        }

        cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == major) {
                cnt++;
            }
        }
        if (cnt > array.length / 2) {
            System.out.println(major + " " + cnt);
        } else {
            System.out.println("no");
        }

    }

    private static int[] initArray() {
        int len = 20;
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(2);
        }
        return array;
    }

}
