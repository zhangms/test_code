package com.jtemp.test.leetcode;


/**
 * Remove Nth Node From End of List 移除链表倒数第N个节点
 * <p>
 * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Chapter18RemoveEndNth {

    static class Node {
        int  value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node list = initLinkList(1, 2, 3, 4, 5);

        print(list);
        removeEndNth(list, 2);
        print(list);

    }

    private static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value).append("->");
            head = head.next;
        }
        System.out.println(sb);
    }

    private static void removeEndNth(Node head, int n) {
        Node node = head;
        int i = 0;
        for (; i < n; i++) {
            node = node.next;
        }
        if (i < n - 1) {
            return;
        }
        Node pre = null;
        Node n2 = head;
        while (node != null) {
            pre = n2;
            n2 = n2.next;
            node = node.next;
        }
        pre.next = n2.next;
    }

    private static Node initLinkList(int... array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Node head = new Node(array[0]);
        Node cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new Node(array[i]);
            cur = cur.next;
        }
        return head;
    }

}
