import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x)
    {
        val = x;
        left = null;
        right = null;
    }
}

class SymmetricTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Symmetric Tree ===");
        
        Solution solution = new Solution();
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n3.right = n5;
        n4.right = n6; n5.left = n7;
        
        System.out.println("isSymmetric = "+solution.isSymmetric(n1));
    }
}

class Solution
{
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null) { return true; }
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        inorder(root, list);
        
        int n = list.size();
        if(n % 2 != 1) { return false; }

        for(int i = 0; i < n/2; i++)
        {
            TreeNode left = list.get(i);
            TreeNode right = list.get(n-1-i);
            
            if(left.val != right.val) { return false; }
        }

        return true;
    }

    public void inorder(TreeNode root, ArrayList<TreeNode> list)
    {
        if(root == null) { return; }
        
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
