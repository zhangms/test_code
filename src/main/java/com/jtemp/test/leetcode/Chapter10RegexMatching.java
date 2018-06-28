package com.jtemp.test.leetcode;

/**
 * Regular Expression Matching 正则表达式匹配
 * <p>
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Chapter10RegexMatching {

    public static void main(String[] args) {

        boolean ret = isMatch("aaa", "aa");
        System.out.println(ret);
    }

    private static boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.equals(pattern)) {
            return true;
        }
        if (pattern.length() == 0) {
            return false;
        }
        if (pattern.length() == 1) {
            if (str.length() > 1) {
                return false;
            } else {
                return pattern.charAt(0) == '.';
            }
        }
        if (pattern.equals(".*")) {
            return true;
        }
        if (str.length() == 0) {
            if (pattern.length() == 2 && pattern.charAt(1) == '*') {
                return true;
            }
        }

        if (pattern.charAt(1) == '*') {
            if (pattern.charAt(0) != str.charAt(0)) {
                return isMatch(str, pattern.substring(2));
            }
            if (isMatch(str, pattern.substring(2))) {
                return true;
            }
            return isMatch(str.substring(1), pattern);
        }
        if (pattern.charAt(0) != str.charAt(0)) {
            return false;
        }
        return isMatch(str.substring(1), pattern.substring(1));
    }

}
