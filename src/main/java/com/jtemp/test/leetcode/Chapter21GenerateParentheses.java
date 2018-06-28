package com.jtemp.test.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Generate Parentheses 生成括号
 * <p>
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Chapter21GenerateParentheses {

    public static void main(String[] args) {

        List<String> ret = generateParentheses(3);
        System.out.println(ret);
    }

    private static List<String> generateParentheses(int n) {

        if (n <= 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList("()");
        }
        return mergeParentheses(generateParentheses(n - 1));
    }

    private static List<String> mergeParentheses(List<String> parentheses) {
        List<String> ret = new ArrayList<>();
        for (String str : parentheses) {
            ret.addAll(mergeParentheses(str));
        }
        return ret;
    }

    private static List<String> mergeParentheses(String str) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                ret.add(str.substring(0, i + 1) + "()" + str.substring(i + 1));
            }
        }
        ret.add(str + "()");
        return ret;
    }

}
