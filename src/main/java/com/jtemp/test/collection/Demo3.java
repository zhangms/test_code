package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Demo3 {

    static class TreeNode {
        public String value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(String value) {
            this.value = value;
        }

        public void addLeft(TreeNode node) {
            left = node;
            if (node != null) {
                node.parent = this;
            }
        }

        public void addRight(TreeNode node) {
            right = node;
            if (node != null) {
                node.parent = this;
            }
        }

        public String preOrder() {
            StringBuilder ret = new StringBuilder();
            ret.append(value);
            if (left != null) {
                ret.append(left.preOrder());
            }
            if (right != null) {
                ret.append(right.preOrder());
            }
            return ret.toString();
        }

        public String inOrder() {
            StringBuilder ret = new StringBuilder();
            if (left != null) {
                ret.append(left.inOrder());
            }
            ret.append(value);
            if (right != null) {
                ret.append(right.inOrder());
            }
            return ret.toString();
        }

        public String lastOrder() {
            StringBuilder ret = new StringBuilder();
            if (left != null) {
                ret.append(left.lastOrder());
            }
            if (right != null) {
                ret.append(right.lastOrder());
            }
            ret.append(value);
            return ret.toString();
        }

        public String upDownOrder() {
            List<String> ret = new ArrayList<>();
            List<TreeNode> list = Arrays.asList(this);
            upDownOrder(ret, list);
            return ret.toString();
        }

        private void upDownOrder(List<String> ret, List<TreeNode> list) {
            if (list.isEmpty()) {
                return;
            }
            ret.addAll(list.stream().map(t -> t.value).collect(Collectors.toList()));
            upDownOrder(ret, list.stream().flatMap(t -> Arrays.asList(t.left, t.right).stream()).filter(Objects::nonNull).collect(Collectors.toList()));
        }


        public static TreeNode buildTree(String preOrder, String inOrder) {
            if (preOrder == null || preOrder.length() == 0) {
                return null;
            }
            if (preOrder.length() == 1) {
                return new TreeNode(preOrder);
            }

            String root = String.valueOf(preOrder.charAt(0));
            String[] subIn = inOrder.split(root);
            if (subIn.length == 1) {
                subIn = new String[]{subIn[0], ""};
            }
            String[] subPre = new String[]{"", ""};
            subPre[0] = preOrder.substring(1, 1 + subIn[0].length());
            subPre[1] = preOrder.substring(1 + subIn[0].length());

            TreeNode node = new TreeNode(root);
            node.addLeft(buildTree(subPre[0], subIn[0]));
            node.addRight(buildTree(subPre[1], subIn[1]));
            return node;
        }

    }

    public static class Solution {

        private String deserializeStr;

        public String Serialize(TreeNode root) {
            if (root == null)
                return "#";
            return root.value + " " + Serialize(root.left) + " " + Serialize(root.right);
        }

        public TreeNode Deserialize(String str) {
            deserializeStr = str;
            return Deserialize();
        }

        private TreeNode Deserialize() {
            if (deserializeStr.length() == 0)
                return null;
            int index = deserializeStr.indexOf(" ");
            String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
            deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
            if (node.equals("#"))
                return null;

            TreeNode t = new TreeNode(node);
            t.left = Deserialize();
            t.right = Deserialize();
            return t;
        }
    }


    public static void main(String[] args) {

        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");
        TreeNode i = new TreeNode("I");
        TreeNode j = new TreeNode("J");
        TreeNode k = new TreeNode("K");

        a.addLeft(b);
        b.addRight(c);
        c.addLeft(d);

        a.addRight(e);
        e.addRight(f);
        f.addLeft(g);
        g.addLeft(h);
        g.addRight(k);

        System.out.println(a.preOrder());
        System.out.println(a.inOrder());
        System.out.println(a.lastOrder());

        System.out.println("-----------");

        TreeNode reBuild = TreeNode.buildTree(a.preOrder(), a.inOrder());

        System.out.println(reBuild.preOrder());
        System.out.println(reBuild.inOrder());
        System.out.println(reBuild.lastOrder());
        System.out.println(reBuild.upDownOrder());

        Solution solution = new Solution();
        String serialize = solution.Serialize(reBuild);

        System.out.println(serialize);

        TreeNode node = solution.Deserialize(serialize);
        System.out.println(node.preOrder());
        System.out.println(node.inOrder());


//        System.out.println("a".substring(1,1).length());
    }

}
