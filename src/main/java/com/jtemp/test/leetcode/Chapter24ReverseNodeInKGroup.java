package com.jtemp.test.leetcode;


/**
 * Reverse Nodes in k-Group 每k个一组翻转链表
 * <p>
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Chapter24ReverseNodeInKGroup {

    static class Node {
        int  value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = initList();
        Node ret = reverseKGroup(head, 3);
        while (ret != null) {
            System.out.println(ret.value);
            ret = ret.next;
        }
    }

    private static Node reverseKGroup(Node list, int k) {
        if (k <= 1 || list == null) {
            return list;
        }

        Node head = list;
        Node cur = list;
        Node ret = null;
        Node pre = null;
        int i = 0;
        while (cur != null) {
            i++;
            if (i % k == 0) {
                Node next = cur.next;
                reverse(head, cur);
                if (ret == null) {
                    ret = cur;
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = head;
                pre.next = next;
                head = next;
                cur = next;
            } else {
                cur = cur.next;
            }
        }
        return ret;
    }

    private static void reverse(Node begin, Node end) {
        end.next = null;
        Node head = begin;
        Node cur = head.next;
        while (cur != null) {
            Node nn = cur.next;
            cur.next = head;
            head = cur;
            cur = nn;
        }
        begin.next = null;
    }

    private static Node initList() {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 2; i <= 10; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        return head;
    }

}
