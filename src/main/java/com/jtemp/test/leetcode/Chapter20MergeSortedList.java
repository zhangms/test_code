package com.jtemp.test.leetcode;

/**
 * Merge Two Sorted Lists 混合插入有序链表
 * <p>
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Chapter20MergeSortedList {

    static class Node {
        int  value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Node list1 = createLinkedList(1, 3, 5, 7, 9);
        Node list2 = createLinkedList(2, 4, 6, 8, 10);

        Node merged = merge(list1, list2);
        print(merged);
    }

    private static void print(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private static Node merge(Node list1, Node list2) {
        Node ret = null;
        Node cur = null;
        while (list1 != null && list2 != null) {
            Node tmp;
            if (list1.value > list2.value) {
                tmp = list2;
                list2 = tmp.next;
            } else {
                tmp = list1;
                list1 = tmp.next;
            }
            if (ret == null) {
                ret = new Node(tmp.value);
                cur = ret;
            } else {
                cur.next = new Node(tmp.value);
                cur = cur.next;
            }
        }

        while (list1 != null) {
            cur.next = new Node(list1.value);
            cur = cur.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            cur.next = new Node(list2.value);
            cur = cur.next;
            list2 = list2.next;
        }
        return ret;
    }

    private static Node createLinkedList(int... sorted) {
        Node head = new Node(sorted[0]);
        Node cur = head;
        for (int i = 1; i < sorted.length; i++) {
            cur.next = new Node(sorted[i]);
            cur = cur.next;
        }
        return head;
    }

}
