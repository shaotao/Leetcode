import java.io.*;
import java.util.*;


class TrimABinarySearchTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Trim A Binary Search Tree ===");
        Solution solution = new Solution();
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n3.left = n0; n3.right = n4;
        n0.right = n2; n2.left = n1;
        int L = 1;
        int R = 3;
        System.out.println("before trim:");
        printTree(n3);
        TreeNode root = solution.trimBST(n3, L, R);
        System.out.println("L = "+L+", R = "+R);
        System.out.println("after trim:");
        printTree(root);
    }

    public static void printTree(TreeNode n) {
        if(n == null) { return; }
        System.out.println(n.val+": ("+((n.left==null)?null:n.left.val)+", "+((n.right==null)?null:n.right.val)+")");
        printTree(n.left);
        printTree(n.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { this.val = x; }
}


class Solution
{
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) { return null; }
        TreeNode left = trimBST(root.left, L, R);
        TreeNode right = trimBST(root.right, L, R);
        if (root.val >= L && root.val <= R) {
            root.left = left;
            root.right = right;
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else if (left == null && right == null) {
            return null;
        } else {
            left = merge(left.right, right);
            return right;
        }
    }

    private TreeNode merge(TreeNode A, TreeNode B) {
        if (A == null && B == null) { return null; }
        else if (A == null && B != null) {
            return B;
        } else if (A != null && B == null) {
            return B;
        } else {
            A.right = merge(A.right, B);
            return A;
        }
    }
}
