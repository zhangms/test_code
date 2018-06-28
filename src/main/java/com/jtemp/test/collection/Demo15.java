package com.jtemp.test.collection;


import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class Demo15 {

    public static void main(String[] args) {
        System.out.println(findFirstNotRepeat("googlebaidul"));
    }

    private static Character findFirstNotRepeat(String str) {

        BitSet set1 = new BitSet();
        BitSet set2 = new BitSet();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set1.get(c)) {
                set2.set(c);
            } else {
                set1.set(c);
            }
            queue.offer(c);
            while (!queue.isEmpty() && set2.get((int) queue.peek())) {
                queue.poll();
            }
        }
        return queue.isEmpty() ? null : queue.peek();
    }
}
