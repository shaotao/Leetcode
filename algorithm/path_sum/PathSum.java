import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class PathSum
{
    public static void main(String[] args)
    {
        TreeNode n5 = new TreeNode(5);

        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);

        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4b = new TreeNode(4);

        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4; n5.right = n8;
        n4.left = n11; n8.left = n13; n8.right = n4b;
        n11.left = n7; n11.right = n2; n4b.right = n1;
        
        Solution solution = new Solution();
        int sum = 22;
        boolean ret = solution.hasPathSum(n5, sum);
        System.out.println("sum = "+sum+", ret = "+ret);
    }
}

class Solution
{
    public Solution()
    {
    }

    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null) { return false; }
        else if(root.left == null && root.right == null)
        {            
            if(sum == root.val) { return true; }
            else { return false; }
        }

        // search the left and right branch
        boolean left = false;
        boolean right = false;
        
        if(root.left != null) { left = hasPathSum(root.left, sum - root.val); }
        if(root.right != null) { right = hasPathSum(root.right, sum - root.val); }

        if(left == true || right == true) { return true; }
        else { return false; }
    }
}
