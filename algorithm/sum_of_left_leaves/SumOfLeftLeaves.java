import java.io.*;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SumOfLeftLeaves
{
    public static void main(String[] args)
    {
	System.out.println("=== Sum of Left Leaves ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(-9);
        TreeNode n2 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(-6);
        TreeNode n8 = new TreeNode(-5);
        n1.left = n2; n1.right = n3;
        n2.right = n4; n3.left=n5; n3.right=n6;
        n4.left = n7; n5.left = n8;

        System.out.println("sum of left leaves = "+solution.sumOfLeftLeaves(n1));
    }
}


class Solution
{
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = 0;

        trace(root, sum);
        
        return sum[0];
    }

    private void trace(TreeNode n, int[] sum) {
        if(n == null) { return; }
        if(n.left !=null && n.left.left == null && n.left.right == null) {
            sum[0] += n.left.val;
        }
        trace(n.left, sum);
        trace(n.right, sum);
    }
}
