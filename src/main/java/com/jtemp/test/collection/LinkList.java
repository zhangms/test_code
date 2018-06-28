package com.jtemp.test.collection;

public class LinkList<T> {

    static class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node setValue(T value) {
            this.value = value;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
    }

    Node<T> head;
    Node<T> last;
    private int size;

    public int size() {
        return size;
    }

    public void add(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = last = node;
            size++;
        } else {
            last.next = node;
            last = node;
            size++;
        }
    }

    /**
     * 打印列表
     */
    public void print() {
        Node<T> p = head;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 逆序打印
     */
    public void reversePrint() {
        reversePrint(head);
        System.out.println();
    }

    private void reversePrint(Node node) {
        if (node != null) {
            reversePrint(node.next);
            System.out.print(node.getValue() + " ");
        }
    }


    /**
     * 逆序
     */
    public void reverse() {
        Node<T> tmp = head;
        head = reverse(head);
        last = tmp;
    }

    private Node<T> reverse(Node<T> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> revert = reverse(node.next);
        node.next.setNext(node);
        node.setNext(null);
        return revert;
    }

    /**
     * 查找倒数第k个节点
     *
     * @param k
     * @return
     */
    public T findBackwardsKNode(int k) {
        if (k < 0 || k >= size) {
            return null;
        }
        int n = size - k - 1;
        Node<T> node = head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node.value;

    }


    /**
     * 创建列表
     *
     * @return
     */
    static LinkList<Integer> createLinkList() {
        LinkList<Integer> ret = new LinkList<>();
        int i = 0;
        while (ret.size() < 10) {
            ret.add(i);
            i += 2;
        }
        return ret;
    }

    static LinkList<Integer> createLinkList2() {
        LinkList<Integer> ret = new LinkList<>();
        int i = 3;
        while (ret.size() < 8) {
            ret.add(i);
            i += 3;
        }
        return ret;
    }

    static LinkList<Integer> merge(LinkList<Integer> list1, LinkList<Integer> list2) {
        LinkList<Integer> ret = new LinkList<>();
        Node<Integer> node1 = list1.head;
        Node<Integer> node2 = list2.head;
        while (node1 != null && node2 != null) {
            if (node1.value >= node2.value) {
                ret.add(node2.value);
                node2 = node2.next;
            } else {
                ret.add(node1.value);
                node1 = node1.next;
            }
        }

        while (node1 != null) {
            ret.add(node1.value);
            node1 = node1.next;
        }
        while (node2 != null) {
            ret.add(node2.value);
            node2 = node2.next;
        }
        return ret;
    }


    public static void main(String[] args) {

        LinkList<Integer> list = createLinkList();
        System.out.println("正向输出：");
        list.print();
        System.out.println("逆向输出：");
        list.reversePrint();

        System.out.println("第二个列表：");
        LinkList<Integer> list2 = createLinkList2();
        list2.print();

        System.out.println("合并列表：");
        merge(list, list2).print();


        System.out.println("倒数第k个节点");
        System.out.println(list.findBackwardsKNode(9));

        System.out.println("反转列表");
        list.reverse();
        list.print();




    }


}
