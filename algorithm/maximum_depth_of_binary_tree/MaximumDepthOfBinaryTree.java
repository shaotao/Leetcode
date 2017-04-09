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
    }
}

class MaximumDepthOfBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Maximum Depth of Binary Tree ===");

	Solution solution = new Solution();
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	
	n1.right = n2; n2.left = n3;
	
	System.out.println("max depth = "+solution.maxDepth(n1));
    }
}

class Value
{
    int val;
    
    public Value(int x)
    {
	val = x;
    }
}

class Solution
{
    public Solution() {}
    
    public int maxDepth(TreeNode root)
    {
	Value result = new Value(0);
	int level = 0;
	search(root, level, result);

	return result.val;
    }

    public void search(TreeNode root, int level, Value result)
    {
	if(root == null) { return; }
	level += 1;
	if(result.val < level) 
	{ 
	    result.val = level; 
	}
	search(root.left, level, result);
	search(root.right, level, result);	
    }
}
