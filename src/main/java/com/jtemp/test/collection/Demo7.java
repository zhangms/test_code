package com.jtemp.test.collection;

/**
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。
 * 模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 */
public class Demo7 {

    static boolean match(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        if (pattern.equals(str)) {
            return true;
        }
        if (pattern.equals(".") && str.length() <= 1) {
            return true;
        }
        if (pattern.equals(".*")) {
            return true;
        }
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        int pIndex = 0;
        int sIndex = 0;

        char pre = 0;
        while (pIndex < pattern.length() && sIndex < str.length()) {
            char p = pattern.charAt(pIndex);
            char s = str.charAt(sIndex);
            switch (p) {
                case '.':
                    pIndex++;
                    sIndex++;
                    break;
                case '*':
                    if (pre == 0) {
                        return false;
                    }
                    if (pre == '.') {
                        if (pIndex == pattern.length() - 1) {
                            return true;
                        }
                        pIndex++;
                        p = pattern.charAt(pIndex);
                        int matchIndex = sIndex++;
                        boolean match = false;
                        while (matchIndex < str.length()) {
                            s = str.charAt(matchIndex);
                            if (s == p) {
                                match = true;
                                sIndex = matchIndex;
                            }
                            matchIndex++;
                        }
                        if (!match) {
                            return false;
                        }
                    } else if (pre != s) {
                        return false;
                    } else {
                        pIndex++;
                        sIndex++;
                    }
                    break;
                default:
                    if (p != s) {
                        return false;
                    } else {
                        pIndex++;
                        sIndex++;
                    }
                    break;
            }
            pre = p;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(match("a.*ab", "aoab"));
    }

}


