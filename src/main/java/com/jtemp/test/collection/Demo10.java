package com.jtemp.test.collection;


import java.util.Stack;

/**
 * 任何时候都可以获取最小元素的栈
 */
public class Demo10 {

    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public void push(Integer val) {
            stack.push(val);
            min.push(min.isEmpty() ? val : Math.min(min.peek(), val));
        }

        public Integer pop() {
            min.pop();
            return stack.pop();
        }

        public Integer min() {
            return min.peek();
        }
    }

}
