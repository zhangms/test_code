package com.jtemp.test.leetcode;


/**
 * Longest Palindromic Substring 最长回文串
 * <p>
 * <p>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class Chapter5LongestPalSub {

    public static void main(String[] args) {

        String str = "sabccbad";
        String ret = longestPalindromicSubstring(str);
        System.out.println(ret);
    }

    private static String longestPalindromicSubstring(String str) {
        String p = null;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= str.length() / 2; j++) {
                String tmp = null;
                if (isPalindromic0(str, i, j)) {
                    tmp = palindromicSubString0(str, i, j);
                }
                if (isPalindromic1(str, i, j)) {
                    tmp = palindromicSubString1(str, i, j);
                }
                if (tmp == null) {
                    break;
                }
                if (p == null || tmp.length() > p.length()) {
                    p = tmp;
                }
            }
        }
        return p;
    }

    private static String palindromicSubString0(String str, int center, int len) {
        return str.substring(center - len, center + len + 1);
    }

    private static String palindromicSubString1(String str, int center, int len) {
        return str.substring(center - len, center + len + 2);
    }

    /**
     * 奇数长度的回文串
     *
     * @param str
     * @param center
     * @param len
     * @return
     */
    private static boolean isPalindromic0(String str, int center, int len) {
        if (center - len < 0 || center + len >= str.length()) {
            return false;
        }
        return str.charAt(center - len) == str.charAt(center + len);
    }

    /**
     * 偶数长度的回文串
     *
     * @param str
     * @param center
     * @param len
     * @return
     */
    private static boolean isPalindromic1(String str, int center, int len) {
        if (center + 1 >= str.length() || center - len < 0 || center + len + 1 >= str.length()) {
            return false;
        }
        return str.charAt(center) == str.charAt(center + 1) && str.charAt(center - len) == str.charAt(center + 1 + len);
    }


}
