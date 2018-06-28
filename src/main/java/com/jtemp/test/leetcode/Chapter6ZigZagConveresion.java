package com.jtemp.test.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * ZigZag Converesion 之字型转换字符串
 * <p>
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * <p>
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class Chapter6ZigZagConveresion {

    public static void main(String[] args) {
        String ret = zigZag("0123456789ABCDEF", 3);
        System.out.println(ret);
    }

    private static String zigZag(String str, int rows) {
        List<List<String>> zig = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            zig.add(new ArrayList<>());
        }
        int index = 0;
        int direct = 1;
        for (int i = 0; i < str.length(); i++) {
            zig.get(index).add(String.valueOf(str.charAt(i)));
            if (index == rows - 1) {
                direct = -1;
            } else if (index == 0) {
                direct = 1;
            }
            index += direct;
        }
        return zig.toString();
    }
}
