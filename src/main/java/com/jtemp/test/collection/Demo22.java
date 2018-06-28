package com.jtemp.test.collection;

import java.util.BitSet;

/**
 * 最长不含重复字符的子字符串
 * <p>
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class Demo22 {

    public static void main(String[] args) {

        String str = "arabcacfrsdzfwewsdfsdf";

        System.out.println(findMaxUniqueSubString(str));

    }

    private static String findMaxUniqueSubString(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        BitSet bitSet = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bitSet.get(c)) {
                break;
            } else {
                bitSet.set(c);
                sb.append(c);
            }
        }
        String ret = findMaxUniqueSubString(str.substring(1));
        return sb.length() > ret.length() ? sb.toString() : ret;
    }

}
