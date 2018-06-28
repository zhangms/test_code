package com.jtemp.test.collection;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Demo16 {

    public static void main(String[] args) {
        Demo16 demo = new Demo16();
        int i = 0;
        while (i++ < 101) {
            demo.add(ThreadLocalRandom.current().nextInt(100));
        }
        System.out.println(demo.getMid());
    }

    private double getMid() {
        return count % 2 == 0 ? (notNull(left.peek()) + notNull(right.peek())) * 1.0 / 2 : notNull(right.peek());
    }

    private double notNull(Integer peek) {
        return peek == null? 0 : peek;
    }

    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> right = new PriorityQueue<>();
    int count = 0;

    private void add(int num) {
        if (count % 2 == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        count++;
    }


}
