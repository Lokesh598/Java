package org.java.learning.dsa.dynamicprogramming.dponbinarytree;


/**
 * The diameter of a tree (sometimes called the width)
 * is the number of nodes on the longest path between two end nodes.
 *
 * @Example:
 * Input:
 *        1
 *      /  \
 *     2    3
 * Output: 3
 */
class Node {
    int data;
    Node left;
    Node right;
    Node next;
    Node(int value) {
        data = value;
        next = null;
    }
    Node(int value, Node left, Node right) {
        this.data = value;
        this.left = left;
        this.right = right;
    }
}
public class DiameterOfBinaryTree {
    /**
     * Java does not allow primitive types to be
     *     passed by reference, we use an array to store the result of the solve function.
     */
    public static int util(Node root, int[] res) {
        if(root == null) return 0;
        int l = util(root.left, res);
        int r = util(root.right, res);

        int tmp = Math.max(l,r)+1;
        int ans = Math.max(tmp, 1+l+r);
        res[0] = Math.max(res[0], ans);
        return tmp;
    }
    public static int diameterOfBinaryTree(Node root) {
        int[] res = {Integer.MIN_VALUE};
        util(root, res);
        return res[0];
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        int ans = diameterOfBinaryTree(node);
        System.out.println(ans);
    }
}
