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


class ValidateBST
{
    public static void main(String[] args)
    {
        //String[] array = {"3", "4", "#", "#", "2", "#", "1"};
        String[] array = {"1", "#", "3", "2"};
        Solution solution = new Solution();

        TreeNode root = solution.create_tree(array);

        solution.print_tree(root);

        boolean result = solution.isValidBST(root);
        System.out.println(result);
    }

}

class Solution
{
    public boolean isValidBST(TreeNode root)
    {
	if(root == null)
	{
	    return true;
	}

	boolean result = check_tree(root.left, root, 1);
	if(result == false)
	{
	    return false;
	}

	result = check_tree(root.right, root, 2);
	if(result == false)
	{
	    return false;
	}
	
	if(root.left != null)
	{
	    result = isValidBST(root.left);
	    if(result == false)
	    {
		return false;
	    }
	}

	if(root.right != null)
	{
	    result = isValidBST(root.right);
	    if(result == false)
	    {
		return false;
	    }
	}
	

	return true;
    }

    public boolean check_tree(TreeNode root, TreeNode target_node, int mode)
    {
	if(root == null)
	{
	    return true;
	}

	if(mode == 1)
	{
	    if(root.val >= target_node.val)
	    {
		return false;
	    }
	}
	else
	{
	    if(root.val <= target_node.val)
	    {
		return false;
	    }
	}
	

	if(root.left != null)
	{
	    boolean left_result = check_tree(root.left, target_node, mode);
	    if(left_result == false)
	    {
		return false;
	    }
	}

	if(root.right != null)
	{
	    boolean right_result = check_tree(root.right, target_node, mode);
	    if(right_result == false)
	    {
		return false;
	    }
	}

	return true;
    }


    public void print_tree(TreeNode root)
    {
        if(root != null)
        {
            System.out.println(root.val);
            if(root.left != null)
            {
                System.out.print("left = ");
                print_tree(root.left);
            }
            if(root.right != null)
            {
                System.out.print("right = ");
                print_tree(root.right);
            }
        }
    }

    public TreeNode create_tree(String[] array)
    {
        ArrayList<TreeNode> node_list = new ArrayList<TreeNode>();
        int idx_list = 0;
        TreeNode root_node = null;
        TreeNode curr_node = null;
        int num_children = 0;

        for(int idx_array = 0; idx_array < array.length; idx_array++)
        {
            String str = array[idx_array];
            TreeNode tree_node = null;
            if(str.equals("#") == false)
            {
                // this is a number
                int val = Integer.parseInt(str);
                tree_node = new TreeNode(val); 
                node_list.add(tree_node);
            }

            if(curr_node == null)
            {
                curr_node = node_list.get(idx_list);
                root_node = curr_node;
                continue;
            }

            if(num_children == 0)
            {
                curr_node.left = tree_node; 

                num_children += 1;
            }
            else if(num_children == 1)
            {
                curr_node.right = tree_node;

                idx_list += 1;
                if(idx_list < node_list.size())
                {
                    curr_node = node_list.get(idx_list);
                }
                num_children = 0;
            }
        }

        return root_node;
    }

}


