import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MinimumAbsoluteDifferenceInBST
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Absolute Difference in BST ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n1.right = n3; n3.left = n2;
        int minDiff = solution.getMinimumDifference(n1);
        System.out.println("min diff = "+minDiff);
    }
}


class Solution
{
    public int getMinimumDifference(TreeNode root) {
        int ret = 0;

        // serialize the tree node
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        storeTree(list, root);

        for(int i = 0; i < list.size()-1; i++) {
            int diff = list.get(i+1).val - list.get(i).val;
            if(i == 0 || ret > diff) { ret = diff; }
        }
        
        return ret;
    }

    private void storeTree(List<TreeNode> list, TreeNode root) {
        if(root == null) { return; }
        storeTree(list, root.left);
        list.add(root);
        storeTree(list, root.right);
    }
}
