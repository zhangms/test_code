package com.jtemp.test.collection;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class Demo19 {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3, 32, 321};
        Arrays.sort(array, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        System.out.println(Stream.of(array).map(String::valueOf).collect(Collectors.joining(",")));
    }
}
