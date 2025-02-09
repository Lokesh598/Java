package org.java.learning.dsa;

import java.util.*;
import java.util.LinkedList;

public class Tree {
    static class TreeNode {
        private final int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
        }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> ans = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.peek();
                int val = tmp.data;
                ans.add(val);
                queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }

            }
            res.add(ans);
        }
        Collections.reverse(res); //will reverse the resultant list
        return res;
    }

    public int maxHeight(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
    public int maxDepthOrLevels(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    private int countLeafNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNodes(root.left)+countLeafNodes(root.right);
    }

    private int countNonLeafNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        return 1+countNonLeafNodes(root.left)+countNonLeafNodes(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSame(root.left, root.right);
    }
    public static boolean isSame(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if ((p != null && q == null) || p == null && q != null) return false;

        if (p.data != q.data) return false;
        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(10);

        Tree.inorder(root);
        List<List<Integer>> res = Tree.levelOrderTraversal(root);
        System.out.print(res);

        System.out.println(tree.maxHeight(root));
        System.out.println("max Depth of tree "+tree.maxDepthOrLevels(root));
        System.out.println("leaf nodes in tree "+tree.countLeafNodes(root));
        System.out.println("non leaf nodes in tree "+tree.countNonLeafNodes(root));
        System.out.println("symetric tree "+tree.isSymmetric(root));

    }
}
