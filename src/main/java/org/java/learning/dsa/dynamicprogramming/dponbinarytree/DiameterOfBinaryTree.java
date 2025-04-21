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
        if(root == null) return 0; //base condition
        int l = util(root.left, res); //hypothesis
        int r = util(root.right, res);//hypothesis

        int tmp = Math.max(l,r)+1; //induction //temprary max
        int ans = Math.max(tmp, 1+l+r); //induction //
        res[0] = Math.max(res[0], ans); //induction
        return tmp;
    }
    public static int diameterOfBinaryTree(Node root) {
        int[] res = {Integer.MIN_VALUE};
        util(root, res);
        return res[0];
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2, new Node(4, null, null), null);
        node.right = new Node(3, new Node(5, null, null), null);


        int ans = diameterOfBinaryTree(node);
        System.out.println(ans);

        System.out.println("diameter:" + diameter(node));

        System.out.println("optimised diameter:" + diameterOptimised(node));
    }


    //diameter using height
    private static int height(Node root) {
        if (root == null) return 0;
        else
            return 1 + Math.max(height(root.left), height(root.right));
    }

    //in this solution we are finding the height for every node, and becs of this we are calculating height repeatedly
    //so we should use dp so that we can reduce repeatedly task.
    public static int diameter(Node root) {
        if (root == null) return 0;

        int d1 = 1+ height(root.left) + height(root.right);

        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    static int res = 0;
    public static int diameterOptimised(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        res = Math.max(res, 1+lh+rh);

        return 1+lh+rh;
    }
}
