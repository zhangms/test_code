package com.jtemp.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters 最长无重复字符的子串
 * <p>
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequenceand not a substring.
 */
public class Chapter3LengthOfNoneRepeatSubstring {

    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(lengthOfNoneRepeatSubString(str));

        str = "pwwkew";
        System.out.println(lengthOfNoneRepeatSubString2(str));
    }

    private static int lengthOfNoneRepeatSubString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                dp[i] = i - map.get(c);
            } else if (i > 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            map.put(c, i);
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }

    private static int lengthOfNoneRepeatSubString2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                curLen = i - map.get(c);
            } else if (i > 0) {
                curLen++;
            } else {
                curLen = 1;
            }
            map.put(c, i);
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }

}
