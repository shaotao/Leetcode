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


class PopulateNRP2
{
    public static void main(String[] args)
    {
        System.out.println("=== RecoverTree ===");

        Solution solution = new Solution();

        //String input = "0,1,2,3,4,5,6";
        //String input = "7,-10,2,-4,3,-8,#,#,#,#,-1,11";
        String input = "1,5,8,9,7,7,8,1,4,8,1,9,0,8,7,1,7,4,2,9,8,2,4,#,#,9,#,#,#,6,0,9,4,1,0,1,8,9,0,1,8,9,1,0,9,6,2,5,#,2,3,0,2,4,8,8,8,5,0,0,9,4,9,1,#,0,7,2,2,3,#,6,1,0,8,9,9,9,4,8,4,3,4,4,0,#,#,8,3,8,#,#,0,#,0,4,9,1,2,#,4,4,0,4,3,5,5,7,4,1,6,#,1,0,#,#,#,2,8,7,7,#,#,0,2,5,5,9,3,3,#,7,6,6,7,9,8,1,7,7,7,2,6,#,7,#,4,6,4,6,#,#,9,1,#,#,#,5,5,5,4,2,2,8,5,1,1,3,1,3,7,#,2,#,9,1,4,4,7,7,#,1,5,6,2,7,3,#,9,1,#,2,4,4,8,#,#,7,#,6,#,7,4,3,5,8,4,8,5,#,#,8,#,#,#,4,4,#,#,#,#,8,3,5,5,#,#,#,1,2,0,#,#,9,3,#,8,3,7,1,8,9,0,1,8,2,#,4,#,#,8,#,#,#,#,2,#,4,8,5,5,3,1,#,#,6,#,1,#,#,6,#,#,#,#,7,3,#,#,#,8,6,4,#,6,9,0,7,8,#,#,0,6,7,#,#,0,0,7,2,3,2,#,0,2,3,#,0,1,7,9,0,7,#,#,#,#,5,8,2,6,3,2,0,4,#,#,0,9,1,1,1,#,1,3,#,7,9,1,3,3,8,#,#,#,#,6,#,#,#,#,9,8,1,3,8,3,0,6,#,#,8,5,6,5,2,1,#,5,#,7,0,0,#,9,3,9,#,3,0,0,9,1,7,0,2,#,6,8,5,#,#,#,#,#,7,#,2,5,#,#,9,#,#,#,#,#,#,#,#,#,#,#,4,1,#,3,6,6,2,5,5,9,#,#,7,8,#,#,2,7,3,7,2,5,#,1,3,4,#,#,8,3,6,9,#,1,#,#,#,#,9,7,5,2,#,5,#,6,4,5,#,1,2,0,6,#,1,6,#,#,5,#,7,8,4,7,8,6,4,#,5,6,7,9,1,0,4,#,#,#,6,4,8,4,5,#,0,4,4,0,1,7,1,#,1,#,3,6,#,#,#,#,8,#,5,0,7,5,#,#,5,8,#,#,3,#,#,8,#,2,4,#,#,#,#,#,#,#,9,#,9,#,9,#,#,#,#,7,1,#,#,2,#,#,5,5,5,5,6,4,#,#,1,6,4,0,#,0,6,3,0,#,5,5,#,#,#,#,2,#,3,6,#,3,0,5,0,1,0,3,4,9,9,2,7,3,8,6,9,#,5,8,#,#,#,#,9,8,0,7,#,#,8,8,6,6,0,2,7,4,2,3,8,6,4,#,8,#,#,#,2,0,#,1,3,5,4,2,2,5,8,8,#,3,0,#,1,6,0,#,#,9,#,2,#,6,8,2,#,#,5,#,#,#,9,6,6,4,2,0,#,#,1,#,0,#,#,#,6,6,#,#,#,4,7,9,#,0,1,#,#,9,#,#,#,4,#,8,#,#,#,#,#,#,4,#,6,#,3,#,#,5,1,2,5,#,0,7,8,#,7,#,#,4,#,4,4,#,2,#,6,#,#,#,7,#,#,#,#,6,4,#,6,#,6,9,#,#,#,9,6,#,9,#,3,#,2,#,7,7,#,#,0,#,6,3,#,#,#,#,#,#,1,#,#,#,6,9,7,#,7,#,9,3,3,#,#,#,#,4,#,#,3,#,#,#,3,9,#,0,3,1,9,6,7,9,4,8,#,#,6,#,1,3,7,#,#,#,3,#,2,#,8,1,1,#,#,6,#,7,3,5,#,6,3,4,#,#,5,7,1,#,#,6,4,6,#,#,#,#,5,7,0,7,0,#,5,8,5,5,4,5,#,#,#,#,#,#,1,7,#,#,7,#,9,9,6,4,#,#,3,2,1,#,0,#,0,6,#,#,#,1,5,#,#,#,8,#,#,#,#,3,4,8,#,#,9,6,4,#,#,#,#,8,9,#,1,#,#,#,7,#,#,#,#,#,9,#,#,#,4,1,6,7,0,#,#,#,7,#,#,8,#,#,#,#,#,#,#,4,#,9,#,#,#,#,3,0,6,#,5,#,9,9,#,#,4,3,4,#,#,#,#,8,#,5,#,#,#,#,5,2,#,#,#,#,#,#,#,2,#,#,2,1,8,5,#,0,#,0,3,2,4,5,#,#,#,#,#,7,#,#,0,#,0,#,#,#,0,3,9,#,#,#,#,5,#,#,0,5,0,0,#,9,#,#,#,#,#,#,#,#,8,#,9,3,5,9,0,5,9,#,#,9,4,#,0,2,0,#,#,7,#,7,#,5,7,8,7,#,#,#,3,0,3,#,#,#,#,#,4,5,#,#,2,3,#,2,#,#,7,#,#,9,#,#,9,7,1,#,#,1,6,1,8,#,#,5,#,#,3,7,9,6,#,#,#,#,1,#,#,#,3,7,3,2,3,3,#,1,#,#,#,1,#,#,4,3,4,8,7,#,0,3,0,#,1,1,#,#,#,#,#,5,#,6,0,#,3,1,#,6,#,#,4,0,1,#,6,1,#,#,9,6,4,9,0,8,9,3,3,6,#,#,#,#,#,#,#,#,#,#,#,#,2,#,#,#,#,#,8,5,8,3,5,4,#,6,#,0,#,#,6,#,4,3,#,#,#,#,#,#,#,#,#,#,#,#,#,#,7,3,#,#,1,#,2,4,#,#,#,6,#,#,#,6,#,5,#,#,#,#,1,#,#,3,#,1,#,7,1,#,#,7,1,3,4,8,#,#,#,#,#,4,#,#,4,#,#,#,7,#,6,#,#,1,#,#,#,7,3,3,#,#,#,#,3,0,#,#,4,#,#,#,#,#,#,#,#,#,#,8,#,#,9,#,#,6,6,5,2,#,8,3,8,#,#,#,#,6,7,0,#,#,#,#,1,1,5,#,0,5,#,5,#,#,#,1,2,#,2,9,1,#,2,4,1,#,#,#,1,8,4,4,5,2,#,#,6,4,7,5,2,9,#,4,#,#,#,#,#,3,#,#,5,9,#,#,#,#,9,#,9,#,#,#,2,#,1,9,#,#,#,#,#,1,9,3,#,#,1,9,#,5,2,1,0,#,#,1,9,8,4,7,#,#,5,7,#,#,#,#,1,2,8,#,6,0,#,#,#,#,0,#,#,#,6,#,2,3,0,9,#,#,1,4,6,#,8,#,#,5,#,3,0,#,6,#,#,#,#,#,2,#,#,#,#,#,#,2,5,8,6,9,#,#,#,8,#,#,9,6,#,#,#,#,3,#,#,#,#,9,#,#,2,#,#,#,#,#,#,8,8,#,#,#,#,#,9,#,6,#,2,5,#,#,1,2,#,4,#,#,4,#,#,3,5,#,3,3,#,#,1,#,#,#,#,4,#,2,3,#,4,5,3,#,7,#,#,#,7,6,#,#,1,3,#,4,9,8,#,#,0,#,3,4,#,8,#,1,#,#,2,2,#,#,4,#,#,#,3,#,#,2,#,#,#,4,#,5,#,#,#,#,2,#,5,#,#,#,#,#,#,2,7,5,#,6,#,#,#,#,2,#,0,#,3,#,1,#,9,4,#,3,#,#,#,#,#,#,#,5,5,7,#,#,1,#,4,6,#,#,#,2,#,5,9,0,6,2,#,#,#,#,#,#,#,#,#,#,#,#,5,#,7,#,2,9,#,#,1,#,#,#,1,6,#,6,#,#,0,8,#,4,#,#,#,#,4,#,#,0,#,6,0,#,#,#,4,#,#,#,#,#,0,#,#,#,#,#,#,#,#,#,#,#,#,0,5,4,2,6,4,5,3,4,#,#,5,#,#,#,#,4,#,#,3,6,2,0,#,6,6,#,#,#,#,0,6,#,#,#,3,9,4,#,#,#,#,#,0,#,#,6,7,0,#,9,2,#,3,3,#,#,8,#,3,#,#,#,8,5,3,#,2,4,#,9,6,9,#,#,#,#,6,#,6,#,5,3,#,#,#,#,4,#,#,#,9,0,9,7,1,1,#,1,#,1,6,#,5,#,6,#,#,1,#,#,#,#,#,#,5,#,#,#,#,#,3,#,6,1,#,0,2,#,#,0,#,#,0,#,#,#,#,#,3,#,#,8,#,#,5,3,3,#,#,#,#,#,#,#,3,#,#,0,8,7,#,#,8,1,#,#,#,#,#,#,7,#,#,#,#,#,#,#,#,#,#,#,5,2,#,2,6,#,#,#,#,#,#,#,1,5,0,#,#,2,#,7,#,#,6,#,#,#,#,#,#,#,#,#,#,#,#,#,8,#,#,#,#,3,#,#,4,#,#,2,#,#,#,#,0,3,#,#,#,#,#,7,#,8,#,#,#,#,8,5,#,3,4,#,#,#,8,#,#,#,#,#,#,#,#,#,3,7,#,#,#,4,0,3,#,#,6,#,#,#,#,#,#,#,#,#,#,#,#,8,#,#,#,#,#,2,#,#,#,#,#,#,#,#,#,0,#,#,#,2,#,#,#,8,2,#,#,#,#,#,#,#,8,#,#,#,#,#,#,#,#,#,#,2,#,#,#,2,5,#,#,#,#,#,#,#,#,#,#,#,2,#,#,#,#,#,8,#,#,#,#,#,#,#,#,#,#,0,5";
	
	PopulateNRP2 pop = new PopulateNRP2();
	TreeLinkNode root = pop.build_tree(input);	

	System.out.println("input = "+input);

	//System.out.println("=== print tree ===");
	//pop.print_tree(root);

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
	    System.out.print("parent = "+root.val+", ");

	    if(root.left != null)
	    {
		System.out.print(root.val+".left = "+root.left.val+", ");
	    }
	    else
	    {
		System.out.print(root.val+".left = #, ");
	    }

	    if(root.right != null)
	    {
		System.out.print(root.val+".right = "+root.right.val+", ");
	    }
	    else
	    {
		System.out.print(root.val+".right = #, ");
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

    // index_layer start from 0, idx_node start from 0 - ((2**idx_layer) -1)
    public TreeLinkNode get_node(TreeLinkNode root, int idx_layer, int idx_node)
    {
        if(root == null || idx_layer <= 0 || idx_node < 0 || idx_node >= Math.pow(2, idx_layer)) { return null; }
	
        // ok, all inputs are valid, now we start to find the node
        TreeLinkNode node = root;
        for(int i = idx_layer; i >= 1; i--)
        {
	    int dir = ((int)Math.pow(2, i-1)) & idx_node;
	    
	    if(dir == 0)
	    {
                // left
                if(node.left != null)
                {
                    node = node.left;
                }
                else
                {
                    node = null;
                    break;
                }
	    }
	    else
	    {
                // right
                if(node.right != null)
                {
                    node = node.right;
                }
                else
                {
		    node = null;
		    break;
		}
	    }
	}
	
        return node;
    }

    public int get_num_layers(TreeLinkNode root, int n)
    {
	int left = n;
	int right = n;
	
	if(root == null) { return n; }
	
	if(root.left != null) { left = get_num_layers(root.left, n+1); }
	if(root.right != null) { right = get_num_layers(root.right, n+1); }
	
	if(left > right) { return left; }
	else { return right; }
    }
    
    public void connect2(TreeLinkNode root)
    {
        int num_layers = get_num_layers(root, 0);

	if(root == null) { return; }

	System.out.println("num_layers = "+num_layers);
	
        // search each layer
        for(int idx_layer = 1; idx_layer <= num_layers; idx_layer++)
        {
            TreeLinkNode prev = null;

            for(int idx_node = 0; idx_node < Math.pow(2, idx_layer); idx_node++)
            {
                TreeLinkNode curr = get_node(root, idx_layer, idx_node);

                //if(curr == null) { System.out.println("row = "+idx_layer+", col = "+idx_node+", node = null"); }
                //else {System.out.println("row = "+idx_layer+", col = "+idx_node+", node = "+curr.val); }

                if(curr == null) { continue; }

                if(prev == null) { prev = curr; continue; }
                else { prev.next = curr; prev = curr; }		
            }
        }
    }

    // find the right most node at the given level
    // if no such level, return null
    public TreeLinkNode find_right(TreeLinkNode root, int level)
    {
        if(level <= 0 || root == null) { return root; }
	
        TreeLinkNode result = null;
        if(root.right != null) { result = find_right(root.right, level-1); }

        if(result == null && root.left != null) { result = find_right(root.left, level-1); }

        return result;
    }

    public TreeLinkNode find_left(TreeLinkNode root, int level)
    {
        if(level <= 0 || root == null) { return root; }
	
        TreeLinkNode result = null;
        if(root.left != null) { result = find_left(root.left, level-1); }

        if(result == null && root.right != null) { result = find_left(root.right, level-1); }

        return result;
    }

    public void connect(TreeLinkNode root)
    {
        if(root == null) { return; }
	
        int level = 0;
        TreeLinkNode left = find_right(root.left, level);
        TreeLinkNode right = find_left(root.right, level);

        //if(left != null && right != null)
        //{
        //    System.out.println("root = "+root.val+", level = "+level+", left = "+left.val+", right = "+right.val);
        //}

        while(left != null && right != null)
        {
            left.next = right;
	    
            level += 1;
	    
            // find the subsequent left and right nodes
            left = find_right(root.left, level);
            right = find_left(root.right, level);
 
            //if(left == null) { System.out.print("level = "+level+", left = #, " ); }
            //else { System.out.print("level = "+level+", left = "+left.val+", "); }

            //if(right == null) { System.out.println("right = #"); }
            //else { System.out.println("right = "+right.val); }
        }

        connect(root.left);
        connect(root.right);
    }
}

