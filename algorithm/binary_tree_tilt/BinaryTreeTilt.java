import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTreeTilt
{
    public static void main(String[] args)
    {
	System.out.println("=== Binary Tree Tilt ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2; n1.right = n3;

        System.out.println("tilt of tree = "+solution.findTilt(n1));
    }
}


class Solution
{
    public int findTilt(TreeNode root) {
        if(root == null) { return 0; }
        int[] tilt = new int[]{0};
        getTilt(root, tilt);
        return tilt[0];
    }

    private void getTilt(TreeNode root, int[] tilt) {
        if(root == null) { return; }
        tilt[0] += (int)Math.abs(sumTree(root.left) - sumTree(root.right));
        getTilt(root.left, tilt);
        getTilt(root.right, tilt);
    }

    private int sumTree(TreeNode root) {
        if(root == null) { return 0; }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
}
