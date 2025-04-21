package org.java.learning.dsa.dynamicprogramming.dponbinarytree;

public class MaximumPathSumFromLeafNodeToLeafNode {
    static int util(Node root, int res[]) {
        if(root == null)
            return 0;

        int l = util(root.left, res);
        int r = util(root.right, res);

        int tmp = Math.max(l, r) + root.data;
        int ans = Math.max(tmp, l + r + root.data);
        res[0] = Math.max(res[0], ans);
        return tmp;
    }
    static int findMaxSum(Node node)
    {
        //your code goes here
        int[] res = {Integer.MIN_VALUE};
        util(node, res);
        return res[0];
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2, new Node(4, null, null), null);
        node.right = new Node(8, new Node(-5, null, null), null);
        node.right.right = new Node(3);

        int ans = findMaxSum(node);
        System.out.println(ans);
    }
}
