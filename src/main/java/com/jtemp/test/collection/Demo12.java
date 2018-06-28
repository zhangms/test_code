package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 */
public class Demo12 {

    public static void main(String[] args) {
        System.out.println(per("abc"));
    }

    /**
     * 排列
     *
     * @param str
     */
    private static List<String> per(String str) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        if (str.length() == 1) {
            return Arrays.asList(str);
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            List<String> list = per(sb.toString());
            for (String s : list) {
                ret.add(c + s);
            }
        }
        return ret;
    }


    /**
     * 组合
     *
     * @param str
     */
    private static void comb(String str) {
        for (int i = 1; i <= str.length(); i++) {
            System.out.println(comb(str, i));
        }
    }

    private static List<String> comb(String str, int len) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        if (len == 1) {
            return Arrays.asList(str.split(""));
        }
        if (str.length() == len) {
            return Arrays.asList(str);
        }
        String first = String.valueOf(str.charAt(0));
        List<String> ret = comb(str.substring(1), len - 1).stream().map(s -> first + s).collect(Collectors.toList());
        ret.addAll(comb(str.substring(1), len));
        return ret;
    }
}
