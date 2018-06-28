package com.jtemp.test.collection;

import java.util.Stack;

public class TwoStackQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void offer(Integer i) {
        stack1.push(i);
    }

    public Integer poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue queue = new TwoStackQueue();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }

}
