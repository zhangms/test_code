package com.jtemp.test.leetcode;

/**
 * Count and Say 计数和读法
 * <p>
 * <p>
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 */
public class Chapter38CountAndSay {


    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            String ret = countAndSay(i);
            System.out.println(ret);
        }
    }

    private static String countAndSay(int n) {
        if (n <= 0) {
            return "1";
        }
        String say = countAndSay(n - 1);
        StringBuilder ret = new StringBuilder();
        char c = say.charAt(0);
        int count = 1;
        for (int i = 1; i < say.length(); i++) {
            if (c == say.charAt(i)) {
                count++;
            } else {
                ret.append(count).append(c);
                c = say.charAt(i);
                count = 1;
            }
        }
        ret.append(count).append(c);
        return ret.toString();

    }

}
