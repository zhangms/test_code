package com.jtemp.test.collection;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列 1,2,3,4,5 是某栈的压入顺序，
 * 序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
 * 但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 */
public class Demo11 {

    public static void main(String[] args) {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4,3,5,2,1};

        Stack<Integer> stack = new Stack<>();
//        int pushIndex = 0;
//        for (int i = 0; i < pop.length; i++) {
//            int p = pop[i];
//            if (!(!stack.isEmpty() && stack.peek().equals(p))) {
//                while (pushIndex < push.length) {
//                    stack.push(push[pushIndex]);
//                    System.out.print(" push(" + stack.peek() + ")");
//                    pushIndex++;
//                    if (stack.peek().equals(p)) {
//                        break;
//                    }
//                }
//            }
//            int s = stack.pop();
//            System.out.print(" pop(" + s + ")");
//            if (s != p) {
//                break;
//            }
//        }

        for (int pushIndex = 0, popIndex = 0; popIndex < pop.length && pushIndex < push.length; pushIndex++) {
            stack.push(push[pushIndex]);
            System.out.println(String.format("push(%s)", stack.peek()));
            while (popIndex < pop.length && stack.peek().equals(pop[popIndex])) {
                int p = stack.pop();
                System.out.println(String.format("pop(%s)", p));
                popIndex++;
            }
        }
        System.out.println(stack.isEmpty());


    }

}
