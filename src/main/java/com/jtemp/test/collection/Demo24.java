package com.jtemp.test.collection;

import java.util.Arrays;

/**
 * 在一个字符串 (1 <= 字符串长度 <= 10000，全部由字母组成) 中找到第一个只出现一次的字符，并返回它的位置。
 */
public class Demo24 {

    public static void main(String[] args) {

        String str = "sdfsfljksfdjpwrepxfwrearwerwxp";

        int[] pos = new int[26];
        Arrays.fill(pos, -1);

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            int p = c - 'a';
            if (pos[p] >= 0) {
                pos[p] = -2;
            } else if (pos[p] == -1) {
                pos[p] = i;
            }
        }

        for (int i = 0; i < pos.length; i++) {
            if (pos[i] >= 0) {
                System.out.println(String.format("%s:%s", (char) (i + 'a'), pos[i]));
                break;
            }
        }


    }

}
