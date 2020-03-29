import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
	this.val = val;	
    }
}

class SameTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Same Tree ===");
	
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	
	n1.left = n2;
	n1.right = n3;

	TreeNode n4 = new TreeNode(1);
	TreeNode n5 = new TreeNode(2);
	TreeNode n6 = new TreeNode(3);
	n4.left = n5;
	n4.right = n6;

	Solution solution = new Solution();

	boolean result = solution.isSameTree(n1, n4);
	
	System.out.println("result = "+result);
    }
}

class Solution
{
    public Solution()
    {
    }

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
	String str_p = preorder(p);
	String str_q = preorder(q);

	return str_p.equals(str_q);
    }

    public String preorder(TreeNode root)
    {
	StringBuffer buf = new StringBuffer("");

	preorder_traversal(root, buf);

	return buf.toString();
    }

    public void preorder_traversal(TreeNode root, StringBuffer buf)
    {
	if(root == null) {
	    buf.append("#");
	}
	else {
	    buf.append(root.val);
	    
	    preorder_traversal(root.left, buf);
	    preorder_traversal(root.right, buf);
	}
    }
}
