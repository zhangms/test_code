package com.jtemp.test.code;

public class LinkListReverse {

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node node = createLinkList();
        print(node);

        node = reverse1(node);
        print(node);

        node = reverse2(node);
        print(node);

    }

    private static Node reverse2(Node node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        Node next = node.next;
        node.next = null;
        Node ret = reverse2(next);
        next.next = node;
        return ret;
    }

    private static Node reverse1(Node node) {
        Node head = node;
        Node cur = node.next;
        head.next = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }
        return head;
    }

    private static void print(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value).append(",");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    private static Node createLinkList() {
        Node head = new Node(0);

        Node tmp = head;
        for (int i = 1; i < 10; i++) {
            tmp.next = new Node(i);
            tmp = tmp.next;
        }
        return head;
    }

}
