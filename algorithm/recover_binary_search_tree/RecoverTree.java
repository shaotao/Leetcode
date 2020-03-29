import java.io.*;
import java.util.*;


//Definition for binary tree
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class RecoverTree
{
    public static void main(String[] args)
    {
	System.out.println("=== RecoverTree ===");

	Solution solution = new Solution();

	String input = "146,71,-13,55,#,231,399,321,#,#,#,#,#,-33";
	
	RecoverTree rec = new RecoverTree();
	TreeNode root = rec.build_tree(input);	

	System.out.println("input = "+input);

	System.out.println("=== print tree ===");
	rec.print_tree(root);

	solution.recoverTree(root);

	System.out.println("=== print tree ===");
	rec.print_tree(root);
    }

    public TreeNode build_tree(String input)
    {
	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	
	TreeNode root = null;

	StringTokenizer stok = new StringTokenizer(input, ",");
	
	int dir = 1;
	while(stok.hasMoreTokens())
	{
	    String val_str = stok.nextToken();
	    
	    TreeNode parent = null;
	    
	    if(list.size() > 0)
	    {
		parent = list.get(0);
	    }

	    if(!val_str.equals("#"))
	    {
		int val = Integer.parseInt(val_str);
		TreeNode node = new TreeNode(val);
		if(root == null)
		{
		    root = node;
		}
		
		list.add(node);
		
		if(parent != null)
		{
		    if(dir == 0)
		    {
			parent.left = node;
		    }
		    else
		    {
			parent.right = node;
			
		    }
		}
	    }

	    if(dir == 1 && parent != null)
	    {
		// remove parent from the list
		list.remove(0);
	    }

	    dir = (dir+1)%2;
	}

	return root;
    }

    public void print_tree(TreeNode root)
    {
	if(root != null)
	{
	    System.out.println("parent = "+root.val);

	    if(root.left != null)
	    {
		System.out.println(root.val+".left = "+root.left.val);
	    }
	    else
	    {
		System.out.println(root.val+".left = #");		
	    }

	    if(root.right != null)
	    {
		System.out.println(root.val+".right = "+root.right.val);
	    }
	    else
	    {
		System.out.println(root.val+".right = #");		
	    }

	    print_tree(root.left);
	    print_tree(root.right);
	}
    }
}

class Pair
{
    TreeNode smaller;
    TreeNode larger;
    
    Pair(TreeNode smaller, TreeNode larger)
    {
	this.smaller = smaller;
	this.larger = larger;
    }
}

class Solution
{
    public Solution()
    {
    }

    public void findInvalidPairs(TreeNode root, ArrayList<Pair> list, TreeNode lower, TreeNode upper)
    {
	if(root.left != null && root.left.val < lower.val)
	{
	    list.add(new Pair(lower, root.left));
	}
	if(root.left != null && root.left.val > upper.val)
	{
	    list.add(new Pair(root.left, upper));	    
	}
	
	if(root.right != null && root.right.val < lower.val)
	{
	    list.add(new Pair(lower, root.right));
	}
	if(root.right != null && root.right.val > upper.val)
	{
	    list.add(new Pair(root.right, upper));
	}
	
	if(root.left != null && root.left.val > root.val)
	{
	    list.add(new Pair(root.left, root));
	}
	if(root.left != null && root.right != null && root.left.val > root.right.val)
	{
	    list.add(new Pair(root.left, root.right));
	}
	if(root.right != null && root.val > root.right.val)
	{
	    list.add(new Pair(root, root.right));
	}
	
	// search the left subtree
	if(root.left != null)
	{
	    if(root.val < upper.val)
	    {
		findInvalidPairs(root.left, list, lower, root);
	    }
	    else
	    {
		findInvalidPairs(root.left, list, lower, upper);
	    }
	}
	
	// search the right subtree
	if(root.right != null)
	{
	    if(root.val > lower.val)
	    {
		findInvalidPairs(root.right, list, root, upper);
	    }
	    else
	    {
		findInvalidPairs(root.right, list, lower, upper);
	    }
	}
    }

    public void recoverTree(TreeNode root)
    {
	// get the min max value
	TreeNode tmp = root;
	while(tmp.left != null)
	{
	    tmp = tmp.left;
	}
	TreeNode min = tmp;
	
	tmp = root;
	while(tmp.right != null)
	{
	    tmp = tmp.right;
	}
	TreeNode max = tmp;

	// get the list of invalid pairs
	ArrayList<Pair> list = new ArrayList<Pair>();
	
	findInvalidPairs(root, list, min, max);
	
	//System.out.println("# of invalid pairs = "+list.size());
	// for(int i = 0; i < list.size(); i++)
	// {
	//     Pair pair = list.get(i);
	//     TreeNode dummy = new TreeNode(-1);
	    
	//     TreeNode smaller = pair.smaller;
	//     if(smaller == null)
	//     {
	// 	smaller = dummy;
	//     }

	//     TreeNode larger = pair.larger;
	//     if(larger == null)
	//     {
	// 	larger = dummy;
	//     }

	//     System.out.println(smaller.val+" -> "+larger.val);	    
	// }
	
	// now we have the list of pairs, get the list of unique nodes
	// and start to swap them
	ArrayList<TreeNode> node_list = new ArrayList<TreeNode>();
	for(int i = 0; i < list.size(); i++)
	{
	    Pair pair = list.get(i);
	    if(node_list.contains(pair.smaller) == false)
	    {
		node_list.add(pair.smaller);
	    }
	    
	    if(node_list.contains(pair.larger) == false)
	    {
		node_list.add(pair.larger);
	    }
	}
	
	// for(int i = 0; i < node_list.size(); i++)
	// {
	//     System.out.println("node "+i+" = "+node_list.get(i).val);
	// }
	
	for(int i = 0; i < node_list.size(); i++)
	{
	    TreeNode node_i = node_list.get(i);
	    boolean done = false;
		
	    for(int j = i+1; j < node_list.size(); j++)
	    {
		TreeNode node_j = node_list.get(j);
		
		boolean passed = true;

		for(int idx_pair = 0; idx_pair < list.size(); idx_pair++)
		{
		    int smaller = list.get(idx_pair).smaller.val;
		    int larger = list.get(idx_pair).larger.val;

		    if(smaller == node_i.val)
		    {
			smaller = node_j.val;
		    }
		    else if(smaller == node_j.val)
		    {
			smaller = node_i.val;
		    }

		    if(larger == node_i.val)
		    {
			larger = node_j.val;
		    }
		    else if(larger == node_j.val)
		    {
			larger = node_i.val;
		    }

		    if(smaller > larger)
		    {
			passed = false;
			break;
		    }
		}
		
		if(passed == true)
		{
		    done = true;
		    int tmp_val = node_i.val;
		    node_i.val = node_j.val;
		    node_j.val = tmp_val;

		    break;
		}

	    }
	    
	    if(done == true)
	    {
		break;
	    }
	}
    }
}

