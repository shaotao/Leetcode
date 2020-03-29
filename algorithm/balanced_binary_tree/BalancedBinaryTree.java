import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x)
    {
        val = x;
    }
}


public class BalancedBinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Balanced Binary Tree ===");

        Solution solution = new Solution();
            
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.left = n8; n4.right = n9;
        n5.left = n10; n5.right = n11;
        n6.left = n12; n6.right = n13;
        n8.left = n14; n8.right = n15;
        
        boolean result = solution.isBalanced(n1);
        
        System.out.println("isBalanced = "+result);
    }
}


class Node
{
    TreeNode tree_node;
    
    Node left;
    Node right;
    int level;
    
    public Node(TreeNode n)
    {
        tree_node = n;
        left = null;
        right = null;
        level = -1;
    }
}


class Solution
{
    public boolean isBalanced(TreeNode root)
    {
        Node n = new Node(root);

        boolean ret = get_level(root, n);

        return ret;
    }
    
    public boolean get_level(TreeNode root, Node n)
    {
        if(root == null || n == null) { return true; }
        
        if(root.left != null) 
        {
            Node left = new Node(root.left);
            n.left = left;

            boolean ret = get_level(root.left, left);
            if(ret == false) { return false; }
        }
        
        if(root.right != null) 
        {
            Node right = new Node(root.right);
            n.right = right;

            boolean ret = get_level(root.right, right);
            if(ret == false) { return false; }
        }
        
        n.level = 1;
        int left_level = 0;
        int right_level = 0;
        if(n.left != null)
        {
            n.level = n.left.level + 1;
            left_level = n.left.level;
        }
        
        if(n.right != null)
        {
            if((n.right.level+1) > n.level)
            {
                n.level = n.right.level + 1;
            }
            right_level = n.right.level;
        }

        //System.out.println("n.val = "+n.tree_node.val+", n.level = "+n.level+", left_level = "+left_level+", right_level = "+right_level);
        
        if(Math.abs(left_level - right_level) > 1)
        {
            //System.out.println("*) n.val = "+n.tree_node.val+", n.level = "+n.level+", left_level = "+left_level+", right_level = "+right_level);
            return false;
        }

        return true;
    }
}

