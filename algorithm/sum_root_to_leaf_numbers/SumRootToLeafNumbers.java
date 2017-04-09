import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SumRootToLeafNumbers
{
    public static void main(String[] args)
    {
	System.out.println("=== Sum Root To Leaf Numbes ===");
	
	Solution solution = new Solution();
	
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	
	n1.left = n2; n1.right = n3;
	n2.right = n4;
	n3.left = n5;
	n5.left = n6;

	System.out.println("sum = "+solution.sumNumbers(n1));
    }
}

class Sum
{
    int val;
    
    public Sum(int x)
    {
	val = x;
    }
}


class Solution
{
    public int sumNumbers(TreeNode root)
    {
	StringBuffer buf = new StringBuffer();
	Sum sum = new Sum(0);

	compute_sum(root, buf, sum);
	
	return sum.val;
    }

    void compute_sum(TreeNode node, StringBuffer buf, Sum sum)
    {
	if(node == null) { return; }
	
	buf.append(node.val);
	if(node.left == null && node.right == null)
	{
	    sum.val += Integer.parseInt(buf.toString());
	}
		   
        if(node.left != null)
	{
	    compute_sum(node.left, buf, sum);
	}
	
	if(node.right != null)
	{
	    compute_sum(node.right, buf, sum);
	}
	
	buf.deleteCharAt(buf.length()-1);
    }
}
