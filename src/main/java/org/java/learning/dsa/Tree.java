package org.java.learning.dsa;

import java.util.*;
import java.util.LinkedList;

/**
 *
 * 1. Lowest common ancestor
 * naive approach - having path arrays - path1 and path2, find common in both and return
 * efficient approach -
 *
 * 2. comvert tree to its mirror image
 *
 */

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
            this.left = left;
            this.right = right;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    private static void iterativeInorder(TreeNode root) {
        System.out.println();
        System.out.print("Iterative inorder");
        Stack<TreeNode> stack = new Stack<>();

        TreeNode tmp = root;
        while (tmp!=null && stack.empty()) {
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            System.out.print(tmp.data);
            tmp = tmp.right;
        }
    }

    private static void iterativePreOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        if (root == null) {
            return;
        }

        st.add(root);

        while (!st.empty()) {
            root = st.pop();
            System.out.println(root.data);

            if (root.left != null) {
                st.add(root.left);
            }

            if (root.right != null) {
                st.add(root.right);
            }
        }
    }

    //using 2 stack
    private static void iterativePostOrder(TreeNode root) {
        System.out.println();
        System.out.print("Iterative postorder");
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.empty()) {
            root = stack1.pop();
            stack2.add(root);

            if (root.left!=null) {
                stack1.add(root.left);
            }

            if (root.right != null) {
                stack1.add(root.right);
            }
        }

        while (!stack2.empty()) {
            System.out.println(stack2.pop());
        }
    }
    //level order + print list level by level
    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        System.out.println();
        System.out.println("Level order traversal");
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

    private static List<List<Integer>> zigZagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.peek();
                int val = treeNode.data;
                levelNodes.add(val);
                queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            if (flag)
                Collections.reverse(levelNodes);

            flag = !flag;
            res.add(levelNodes);

        }
        return res;
    }

    static class Pair<u, v> {
        u first;
        v second;

        Pair(u first, v second) {
            this.first = first;
            this.second = second;

        }
        public u getKey() {
            return first;
        }
        public v getValue() {
            return second;
        }
    }

    //this not correct code
    private List<List<Integer>> verticalTraversalBinaryTree (TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Integer>> mp = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();

            int size = queue.size();
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int horizontalDis = pair.getValue();

            for (int i = 0; i < size; i++) {

                tmp.add(node.data);

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, horizontalDis-1));
                }
                if (node.right != null) {
                    queue.add(new Pair<>(node.right, horizontalDis+1));
                }



            }

            if (!mp.containsKey(horizontalDis)) {
                mp.put(horizontalDis, tmp);
            }

        }

        for (List<Integer> val : mp.values()) {
            res.add(val);
        }
        return res;
    }

    private List<Integer> topViewBinaryTree (TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> mp = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue(); // horizontal distance

            if (!mp.containsKey(line)) {
                mp.put(line, node.data);
            }
            if (node.left != null) {
                queue.add(new Pair<>(node.left, line-1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, line+1));
            }
        }

        for (int value : mp.values()) {
            res.add(value);
        }
        return res;
    }

    private List<Integer> bottomViewBinaryTree (TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> mp = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue(); // horizontal distance

            mp.put(line, node.data); //overwrite the value of encountering at line.
            if (node.left != null) {
                queue.add(new Pair<>(node.left, line-1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, line+1));
            }
        }

        for (int value : mp.values()) {
            res.add(value);
        }
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

    public int diameterOfBT() {return 0;}

    public TreeNode mirrorOfBT(TreeNode root) {

        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirrorOfBT(root.left);
        mirrorOfBT(root.right);

        return root;
    }

    static class Distance {
        int val;

        Distance(int x) {
            val = x;
        }
    }
    int res = 0;
    public int burnTree(TreeNode root, int key, Distance dist) {
        if (root == null) return 0;

        if (root.data == key) {
            dist.val = 0;
            return 1;
        }
        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        int lh = burnTree(root.left, key, ldist);
        int rh = burnTree(root.right, key, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val+1;
            res = Math.max(res, ldist.val+rh);
        }

        if (rdist.val != -1) {
            dist.val = rdist.val+1;
            res = Math.max(res, rdist.val+lh);
        }


        return 1 + Math.max(lh, rh);
    }

    static class LCA {
        static class Node {
            int key;
            Node left;
            Node right;
            Node(int k){
                key=k;
                left=right=null;
            }
        }
        public static void main(String args[])
        {
            Node root=new Node(10);
            root.left=new Node(20);
            root.right=new Node(30);
            root.right.left=new Node(40);
            root.right.right=new Node(50);
            int n1=30,n2=50;

            Node ans=lcaNaive(root,n1,n2);
//            System.out.println("LCA: "+ans.key);
            System.out.println("Lca optimal:" + lcaOptimal(root, n1, n2).key);
        }

        public static boolean findPath(Node root, ArrayList<Node> p, int n){
            if(root==null) return false;
            p.add(root);
            if(root.key==n) return true;

            if(findPath(root.left,p,n)||findPath(root.right,p,n))return true;

            p.remove(p.size()-1);
            return false;
        }

        public static Node lcaNaive(Node root, int n1, int n2){
            ArrayList <Node> path1=new ArrayList<>();
            ArrayList <Node> path2=new ArrayList<>();
            if(findPath(root,path1,n1)==false||findPath(root,path2,n2)==false)
                return null;
            for(int i=0;i<path1.size()-1 && i<path2.size()-1;i++)
                if(path1.get(i+1)!=path2.get(i+1))
                    return path1.get(i);
            return null;
        }

        private static Node lcaOptimal(Node root, int n1, int n2) {

            if (root == null)
                return root;

            if (root.key == n1 || root.key == n2)
                return root;

            Node left = lcaOptimal(root.left, n1, n2);
            Node right = lcaOptimal(root.right, n1, n2);

            if (left != null && right != null ){
                return root;
            }

            return (left != null)?left:right;
        }
    }

    static class ConstructBT {

        static class Node {
            int key;
            Node left;
            Node right;
            Node(int k){
                key=k;
                left=right=null;
            }
        }

        public static void main(String args[])
        {
            int in[]={20,10,40,30,50};
            int pre[]={10,20,30,40,50};
            int n= in.length;
            Node root=cTree(in, pre, 0, n-1);
            Node root1 = buildTree(in, pre);
            inorder(root); //print tree
        }

        static int preIndex=0;
        public static Node cTree(int in[],int pre[],int is,int ie){
            if(is>ie)return null;
            Node root=new Node(pre[preIndex++]);

            int inIndex=is;

            //in optimization of this code we can use hashmap, we can store instore element and indexes in array
            // here this loop we are keep running for each recursive call
            for(int i=is;i<=ie;i++){
                if(in[i]==root.key){
                    inIndex=i;
                    break;
                }
            }
            root.left=cTree(in, pre, is, inIndex-1);
            root.right=cTree(in, pre, inIndex+1, ie);
            return root;
        }

        public static void inorder(Node root){
            if(root!=null){
                inorder(root.left);
                System.out.print(root.key+" ");
                inorder(root.right);
            }
        }

        public static Node cNode(int[] in, int[] post, int is, int ie, int ps, int pe) {

            if (is>ie) return null;

            if (pe < 0) return null;

            Node root = new Node(post[pe]);

            int inInd = is;

            for (int i = is; i <= ie; i++) {
                if(in[i] == root.key) {
                    inInd = i;
                    break;
                }
            }

            root.left = cNode(in, post, is, inInd-1, ps, ps+inInd-is-1);
            root.right = cNode(in, post, inInd+1, ie, ps+inInd-is, pe-1);

            return root;
        }

        public static Node buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            int postInd = n-1;
            return cNode(inorder, postorder, 0, n-1, 0, n-1);
        }
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
        Tree.iterativeInorder(root);
        List<List<Integer>> res = Tree.levelOrderTraversal(root);
        System.out.print(res);
        System.out.println();
        System.out.print("zig zag traversal");
        List<List<Integer>> zigZag = Tree.zigZagLevelOrderTraversal(root);
        System.out.println(zigZag);

        System.out.println("max Depth of tree "+tree.maxHeight(root));
        System.out.println("max Depth of tree "+tree.maxDepthOrLevels(root));
        System.out.println("leaf nodes in tree "+tree.countLeafNodes(root));
        System.out.println("non leaf nodes in tree "+tree.countNonLeafNodes(root));
        System.out.println("symetric tree "+tree.isSymmetric(root));

        System.out.println("Mirror of Tree " + tree.mirrorOfBT(root));
        List<List<Integer>> mirror = Tree.levelOrderTraversal(root);
        System.out.println(mirror);
        System.out.println("Vertical order traversal of Tree " + tree.verticalTraversalBinaryTree(root));
        System.out.println("Top view of Tree " + tree.topViewBinaryTree(root));
        System.out.println("Bottom view of Tree " + tree.bottomViewBinaryTree(root));

        Distance dist = new Distance(1);
        System.out.println("Burn tree in time : "+ tree.burnTree(root, 7, dist));
    }
}
