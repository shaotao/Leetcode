import java.io.*;
import java.util.*;


class HouseRobber3
{
    public static void main(String[] args)
    {
	System.out.println("=== House Robber III ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.right = n6;

        System.out.println("max = "+solution.rob(n1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution
{
    public int rob(TreeNode root) {
        if(root == null) { return 0; }
        if(root.left == null && root.right == null) { return root.val; }

        int with_root = root.val;
        if(root.left != null) {
            with_root += rob(root.left.left);
            with_root += rob(root.left.right);
        }
        if(root.right != null) {
            with_root += rob(root.right.left);
            with_root += rob(root.right.right);
        }

        int no_root = rob(root.left) + rob(root.right);
        
        return (with_root > no_root)?with_root:no_root;
    }
}
