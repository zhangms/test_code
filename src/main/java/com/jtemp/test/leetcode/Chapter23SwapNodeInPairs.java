package com.jtemp.test.leetcode;


/**
 * Swap Nodes in Pairs 成对交换节点
 * <p>
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class Chapter23SwapNodeInPairs {

    static class Node {
        int  value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Node list = new Node(1);
        Node cur = list;
        for (int i = 2; i <= 10; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }

        Node ret = swap(list);

        while (ret != null) {
            System.out.println(ret.value);
            ret = ret.next;
        }

    }

    private static Node swap(Node list) {
        Node head = list;
        if (head.next == null) {
            return head;
        }
        Node ret = head.next;
        Node pre = null;
        while (head != null && head.next != null) {
            Node next = head.next;
            Node nextNext = next.next;
            next.next = head;
            head.next = nextNext;
            if (pre != null) {
                pre.next = next;
            }
            pre = head;
            head = nextNext;
        }
        return ret;
    }


}
