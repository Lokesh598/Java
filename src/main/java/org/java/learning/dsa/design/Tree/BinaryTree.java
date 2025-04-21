package org.java.learning.dsa.design.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) { val = x; }
    TreeNode (int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = new TreeNode();
    }

    public void insertNode(int val) {
        insertNodeRec(root, val);
    }

    public TreeNode insertNodeRec(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (val < node.val) {
            node.left = insertNodeRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertNodeRec(node.right, val);
        }
        return node;
    }
    public void traverseTree() {
        printNodes(root);
    }
    public void printNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printNodes(root.left);
        printNodes(root.right);
    }
}

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        BinaryTree bt = new BinaryTree();
        for (int i = 1; i < 5; i++) {
            bt.insertNode(i);
        }
        bt.printNodes(root);
        System.out.println("printing bs tree");
        bt.traverseTree();
    }
}

class Solution1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        root.left = left;
        root.right = right;
        BinaryTree bt = new BinaryTree();
        bt.printNodes(root);
    }
}
/**
 * 1. find tree hight
 * 2. count child nodes
 * 3. count non leaf nodes
 * 4.
 */