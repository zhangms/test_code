package com.jtemp.test.leetcode;

import java.util.Stack;

/**
 * Valid Parentheses 验证括号
 * <p>
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Chapter19ValidParentheses {

    public static void main(String[] args) {

        boolean valid = validParentheses("{{The (brackets) {must [close in (the) correct] order},determine if the input string is valid}}");
        System.out.println(valid);
    }

    private static boolean validParentheses(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isLeftParentheses(c)) {
                stack.push(c);
            } else if (isRightParentheses(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!isParenthesesMatched(left, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isParenthesesMatched(char left, char right) {
        return (left == '(' && right == ')')
                || (left == '{' && right == '}')
                || (left == '[' && right == ']');
    }

    private static boolean isLeftParentheses(char c) {
        switch (c) {
            case '{':
            case '[':
            case '(':
                return true;
            default:
                return false;
        }
    }


    private static boolean isRightParentheses(char c) {
        switch (c) {
            case '}':
            case ']':
            case ')':
                return true;
            default:
                return false;
        }
    }

}
