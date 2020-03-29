import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class DiameterOfBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Diameter of Binary Tree ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2; n1.right = n3;
        n2.left= n4; n2.right = n5;

        int ret = solution.diameterOfBinaryTree(n1);
        System.out.println("diameter = "+ret);
    }
}


class Solution
{
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 0;

        checkDepth(root, diameter);
        return diameter[0];
    }

    public int checkDepth(TreeNode n, int[] diameter) {
        int depth = 0;
        if(n==null) { depth = 0; }
        else {
            int left = (n.left!=null)?(1+checkDepth(n.left, diameter)):0;
            int right = (n.right!=null)?(1+checkDepth(n.right, diameter)):0;

            if(diameter[0] < (left+right)) { diameter[0] = left+right; }
            depth = (left>=right?left:right);
        }

        return depth;
    }
}
