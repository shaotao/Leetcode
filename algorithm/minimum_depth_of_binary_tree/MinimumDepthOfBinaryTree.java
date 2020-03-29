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

class MinimumDepthOfBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Depth of Binary Tree ===");

	Solution solution = new Solution();
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	
	n1.right = n2; n2.left = n3;
	
	System.out.println("min depth = "+solution.minDepth(n1));
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
    
    public int minDepth(TreeNode root)
    {
	Value result = new Value(-1);
	int level = 0;

	if(root == null) { return 0; }

	search(root, level, result);

	return result.val;
    }

    public void search(TreeNode root, int level, Value result)
    {
	if(root == null) { return; }

	level += 1;

	if(result.val >= 0 && level >= result.val)
	{
	    return;
	}

	if(root.left == null && root.right == null)
	{
	    if(result.val == -1 || result.val > level)
	    {
		result.val = level;
	    }
	}

	search(root.left, level, result);
	search(root.right, level, result);
    }
}
