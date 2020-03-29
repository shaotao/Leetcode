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

class FlattenBinaryTreeToLinkedList
{
    public static void main(String[] args)
    {
        System.out.println("=== Flatten Binary Tree to Linked List ===");
        
        Solution solution = new Solution();
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        
        n1.left = n2; n1.right = n5;
        n2.left = n3; n2.right = n4;
        n5.right = n6;

        solution.flatten(n1);
        
        TreeNode t = n1;
        System.out.print("list: ");
        while(t != null)
        {
            System.out.print(t.val+" ");
            t = t.right;
        }
        System.out.println();
    }
}


class Solution
{
    public void flatten(TreeNode root)
    {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        to_list(root, list);
        
        for(int i = 0; i < list.size()-1; i++)
        {
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
    }

    public void to_list(TreeNode node, ArrayList<TreeNode> list)
    {
        if(node == null) { return; }        
        list.add(node);

        to_list(node.left, list);
        to_list(node.right, list);
    }
}
