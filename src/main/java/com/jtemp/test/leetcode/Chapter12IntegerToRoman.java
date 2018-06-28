package com.jtemp.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Integer to Roman 整数转化成罗马数字
 * <p>
 * <p>
 * Given an integer, convert it to a roman numeral.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * 百科
 * https://baike.baidu.com/item/罗马数字/772296
 */
public class Chapter12IntegerToRoman {

    static Map<Integer, Character> characterMap = new HashMap<>();

    public static void main(String[] args) {

        initCharacterMap();

        int val = 1490;
        String ret = toRoman(val);
        System.out.println(ret);
    }

    private static void initCharacterMap() {
        characterMap.put(1, 'I');
        characterMap.put(5, 'V');
        characterMap.put(10, 'X');
        characterMap.put(50, 'L');
        characterMap.put(100, 'C');
        characterMap.put(500, 'D');
        characterMap.put(1000, 'M');
    }

    private static String toRoman(int val) {
        if (val < 1 || val > 3999) {
            throw new IllegalArgumentException(String.valueOf(val));
        }
        StringBuilder ret = new StringBuilder();
        int power = 1;
        while (val > 0) {
            int m = val % 10;
            val = val / 10;
            ret.insert(0, toRoman(m, power));
            power *= 10;
        }
        return ret.toString();
    }

    private static String toRoman(int number, int power) {

        Character one = characterMap.get(power);
        Character five = characterMap.get(power * 5);
        Character ten = characterMap.get(power * 10);

        if (number == 0) {
            if (power == 1) {
                return "";
            } else {
                return ten.toString();
            }
        }
        if (number <= 3) {
            char[] ret = new char[number];
            Arrays.fill(ret, one);
            return new String(ret);
        }
        if (number <= 5) {
            char[] ret = new char[5 - number + 1];
            Arrays.fill(ret, one);
            ret[ret.length - 1] = five;
            return new String(ret);
        }
        if (number <= 8) {
            char[] ret = new char[number - 5 + 1];
            Arrays.fill(ret, one);
            ret[0] = five;
            return new String(ret);
        }
        return one.toString() + ten.toString();
    }

}
