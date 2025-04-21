package org.java.learning.dsa.dynamicprogramming.dponbinarytree;

public class MaximumPathSumFromAnyNodeToAnyNode {
    static int res;
    static int util(Node root) {
        if(root == null)
            return 0;

        int l = util(root.left);
        int r = util(root.right);

        int tmp = Math.max(Math.max(l, r) + root.data, root.data);
        int ans = Math.max(tmp, l + r + root.data);
        res = Math.max(res, ans);
        return tmp;
    }
    static int findMaxSum(Node node)
    {
        //your code goes here
        res = Integer.MIN_VALUE;
        util(node);
        return res;
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2, new Node(4, null, null), null);
        node.right = new Node(8, new Node(-5, null, null), null);

        int ans = findMaxSum(node);
        System.out.println(ans);
    }
}
