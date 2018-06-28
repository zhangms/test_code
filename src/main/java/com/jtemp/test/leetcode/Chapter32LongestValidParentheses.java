package com.jtemp.test.leetcode;


import java.util.Stack;

/**
 * Longest Valid Parentheses 最长有效括号
 * <p>
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Chapter32LongestValidParentheses {


    public static void main(String[] args) {

        int ret = validParentheses(")(()())");
        System.out.println(ret);
    }

    private static int validParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                for (int j = s.length() - 1; j > i; j--) {
                    if (isValidParentheses(s, i, j)) {
                        return j - i + 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isValidParentheses(String s, int start, int end) {
        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (stack.size() > 0 && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
