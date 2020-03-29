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


class ConvertSortedArrayToBinarySearchTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Convert Sorted Array to Binary Search Tree ===");
        Solution solution = new Solution();
        
        int[] num = {-1, 0, 1, 2, 3, 6};
        
        TreeNode root = solution.sortedArrayToBST(num);
        
        print_tree(root);
    }
    
    public static void print_tree(TreeNode root)
    {
        if(root == null) { return; }
        
        System.out.print("node: "+root.val);
        if(root.left != null) 
        { 
            System.out.print(", left = "+root.left.val);
        }
        else
        {
            System.out.print(", left = null");            
        }

        if(root.right != null) 
        { 
            System.out.print(", right = "+root.right.val);
            
        }
        else
        {
            System.out.print(", right = null");            
        }
        System.out.println();

        if(root.left != null) { print_tree(root.left); }
        if(root.right != null) { print_tree(root.right); }
    }
}


class Solution
{
    public TreeNode sortedArrayToBST(int[] num)
    {
        if(num.length <= 0) { return null; }

        TreeNode root = fetch_node(num, 0, num.length-1);

        return root;
    }

    public TreeNode fetch_node(int[] num, int start_idx, int end_idx)
    {
        if(start_idx > end_idx)
        {
            return null;
        }
        
        int middle_idx = (start_idx+end_idx)/2;
        TreeNode node = new TreeNode(num[middle_idx]);

        node.left = fetch_node(num, start_idx, middle_idx-1);
        node.right = fetch_node(num, middle_idx+1, end_idx);

        return node;
    }
}

