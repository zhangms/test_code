package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数字，
 * 按照如下规则翻译成字符串：
 * 0 翻译成“a”，1 翻译成“b”... 25 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，
 * 分别是 bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class Demo20 {

    static String[] words = new String[26];

    private static void initWords() {
        for (int i = 0; i < 26; i++) {
            words[i] = String.valueOf((char) ('a' + i));
        }
    }

    public static void main(String[] args) {
        initWords();

        int number = 1234567123;
        System.out.println(numberEncode(number));
        System.out.println(numberEncodeCount(number));


    }

    private static int numberEncodeCount(int number) {
        if (number < 0) {
            return 0;
        }
        if (number < 10) {
            return 1;
        }
        if (number < 26) {
            return 2;
        }
        if (number < 100) {
            return 1;
        }
        String str = String.valueOf(number);
        int value = numberEncodeCount(Integer.parseInt(str.substring(1)));
        if (Integer.parseInt(str.substring(0, 2)) < 26) {
            value += numberEncodeCount(Integer.parseInt(str.substring(2)));
        }
        return value;
    }


    private static List<String> numberEncode(int number) {
        if (number < 0) {
            return Collections.singletonList("");
        }
        if (number < 10) {
            return Collections.singletonList(words[number]);
        }
        List<String> ret = new ArrayList<>();
        int[] array = split(number, 1);
        String c = words[array[0]];
        for (String s : numberEncode(array[1])) {
            ret.add(c + s);
        }
        array = split(number, 2);
        if (array[0] < 26) {
            c = words[array[0]];
            for (String s : numberEncode(array[1])) {
                ret.add(c + s);
            }
        }
        return ret;
    }

    private static int[] split(int number, int i) {
        int[] ret = new int[]{-1, -1};
        if (number < 0) {
            return ret;
        }
        if ((number < 10 && i == 1) || (number < 100 && i == 2)) {
            ret[0] = number;
            return ret;
        }
        String str = String.valueOf(number);
        ret[0] = Integer.parseInt(str.substring(0, i));
        ret[1] = Integer.parseInt(str.substring(i));
        return ret;
    }

}
