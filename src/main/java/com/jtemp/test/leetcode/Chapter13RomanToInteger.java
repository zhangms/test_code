package com.jtemp.test.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer 罗马数字转化成整数
 * <p>
 * <p>
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Chapter13RomanToInteger {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        initCharacterMap();
        int val = romanToInteger("MCDXC");
        System.out.println(val);
    }

    private static void initCharacterMap() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private static int romanToInteger(String roman) {
        if (roman == null || roman.length() == 0) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < roman.length() - 1; i++) {
            char cur = roman.charAt(i);
            char next = roman.charAt(i + 1);
            int curI = map.get(cur);
            int nextI = map.get(next);
            if (nextI > curI) {
                ret -= curI;
            } else {
                ret += curI;
            }
        }

        char last = roman.charAt(roman.length() - 1);
        int lastI = map.get(last);
        return ret + lastI;
    }

}
