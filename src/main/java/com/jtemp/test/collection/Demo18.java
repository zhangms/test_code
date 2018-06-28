package com.jtemp.test.collection;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 数字序列中的某一位数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 */
public class Demo18 {

    public static void main(String[] args) {
        //长度为i的数字总共有多少个
        int[] countArray = new int[8];

        //长度为i的数字全部转化成字符串拼接后，字符串长度是多少
        int[] lenArray = new int[8];
        for (int i = 1; i < 8; i++) {
            countArray[i] = (int) Math.pow(10, i) - IntStream.of(countArray).skip(i - 1).limit(i).sum();
            lenArray[i] = countArray[i] * i;
        }
        System.out.println(IntStream.of(countArray).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.of(lenArray).boxed().collect(Collectors.toList()));

        int index = 300;
        int i = 0;
        while (i < lenArray.length) {
            if (index - lenArray[i] >= 0) {
                index -= lenArray[i];
                i++;
            } else {
                break;
            }
        }

        System.out.println(String.format("%s位数，第%s位", i, index));

        int val = index / i + IntStream.of(countArray).limit(i).sum();

        System.out.println(String.format("结果：%s", val));

//        String str = initNumberString(val);
//        System.out.println(str);
//        System.out.println(str.length());

    }

    private static String initNumberString(int val) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i <= val; i++) {
            ret.append(i);
        }
        return ret.toString();
    }

}
