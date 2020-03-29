import java.io.*;
import java.util.*;


//Definition for binary tree
class TreeLinkNode 
{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    TreeLinkNode(int x) { val = x; }
}


class PopulateNRP
{
    public static void main(String[] args)
    {
	System.out.println("=== RecoverTree ===");

	Solution solution = new Solution();

	String input = "0,1,2,3,4,5,6";
	
	PopulateNRP pop = new PopulateNRP();
	TreeLinkNode root = pop.build_tree(input);	

	System.out.println("input = "+input);

	System.out.println("=== print tree ===");
	pop.print_tree(root);

	solution.connect(root);

	System.out.println("=== print tree ===");
	pop.print_tree(root);
    }

    public TreeLinkNode build_tree(String input)
    {
	ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
	
	TreeLinkNode root = null;

	StringTokenizer stok = new StringTokenizer(input, ",");
	
	int dir = 1;
	while(stok.hasMoreTokens())
	{
	    String val_str = stok.nextToken();
	    
	    TreeLinkNode parent = null;
	    
	    if(list.size() > 0)
	    {
		parent = list.get(0);
	    }

	    if(!val_str.equals("#"))
	    {
		int val = Integer.parseInt(val_str);
		TreeLinkNode node = new TreeLinkNode(val);
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

    public void print_tree(TreeLinkNode root)
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
	    
	    if(root.next != null)
	    {
		System.out.println(root.val+".next = "+root.next.val);
	    }
	    else
	    {
		System.out.println(root.val+".next = #");		
	    }

	    print_tree(root.left);
	    print_tree(root.right);
	}
    }
}


class Solution
{
    public Solution()
    {
    }

    public void traverse_in_order(TreeLinkNode root, ArrayList<TreeLinkNode> list)
    {
	if(root == null) { return; }
	
	if(root.left != null) { traverse_in_order(root.left, list); }

	list.add(root);

	if(root.right != null) { traverse_in_order(root.right, list); }
    }

    public void connect(TreeLinkNode root)
    {
	ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();

	traverse_in_order(root, list);
	
	for(int i = 0; i < list.size() ;i++)
	{
	    int head_idx = (int) (Math.pow(2, i) -1);
	    int gap = (int)(Math.pow(2, i+1));

	    if(head_idx >= list.size()) { break; }

	    for(int j = 0; j < list.size(); j++)
	    {
		int idx_curr = head_idx + j*gap;
		int idx_next = head_idx + (j+1)*gap;

		// check if we can connect two nodes
		if(idx_curr >= list.size() ||
		   idx_next >= list.size())
		{
		    // either the current index or the next node's index
		    // is out of range, break here
		    break;
		}
		
		// ok, we can connect
		TreeLinkNode curr = list.get(idx_curr);
		TreeLinkNode next = list.get(idx_next);
		
		curr.next = next;
	    }
	}
    }
}

