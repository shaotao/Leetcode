import java.io.*;
import java.util.*;


class BinaryTreePreorderTraversal
{
    public static void main(String[] args)
    {
	System.out.println("=== Binary Tree Preorder Traversal ===");
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2); 
	TreeNode n3 = new TreeNode(3);
	
	n1.right = n2; n2.left = n3;
	
	Solution solution = new Solution();
	
	ArrayList<Integer> list = solution.preorderTraversal(n1);
	print_list(list);
    }
    
    public static void print_list(ArrayList<Integer> list)
    {
	System.out.print("list: ");
	for(int i = 0; i < list.size(); i++)
	{
	    System.out.print(list.get(i)+" ");
	}
	System.out.println();
    } 
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) { val = x; }
}

class Solution
{
    public Solution() {}
    
    public ArrayList<Integer> preorderTraversal(TreeNode root)
    {
	ArrayList<Integer> result = new ArrayList<Integer>();
	
	traverse(root, result);
	
	return result;
    }

    public void traverse(TreeNode root, ArrayList<Integer> list)
    {
	if(root == null) { return; }
	
	list.add(root.val);
	traverse(root.left, list);
	traverse(root.right, list);
    }
}
