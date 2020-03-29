import java.io.*;
import java.util.*;


class LowestCommonAncestorOfABinarySearchTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Lowest Common Ancestor Of A Binary Search Tree ===");
        Solution solution = new Solution();

        TreeNode n0 = new TreeNode(0);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n6.left = n2;
        n6.right = n8;
        n2.left = n0;
        n2.right = n4;
        n4.left = n3;
        n4.right = n5;
        n8.left = n7;
        n8.right = n9;

        System.out.println("LCA of 2 and 8 is: "+solution.lowestCommonAncestor(n6, n2, n8).val);
        System.out.println("LCA of 2 and 4 is: "+solution.lowestCommonAncestor(n6, n2, n4).val);
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) { val = x; }
}

class Solution
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        if(!find(root, p) || !find(root, q)) { return null; }

        if(find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if( find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public boolean find(TreeNode root, TreeNode target) {
        if(root == null || target == null) {
            return false;
        }

        if(target.val == root.val) {
            return true;
        } else if(target.val < root.val) {
            return find(root.left, target);
        } else {
            return find(root.right, target);
        }
    }
}
