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


class BTreeLevelorder
{
    public static void main(String[] args)
    {
        String[] array = {"3", "9", "20", "#", "#", "15", "7"};
        Solution solution = new Solution();

        TreeNode root = solution.create_tree(array);

        solution.print_tree(root);

        ArrayList<ArrayList<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }

}

class Solution
{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // get the depth of the tree
        int num_levels = get_num_levels(root);
        //System.out.println("num_levels = "+num_levels);

        for(int i = 0; i < num_levels; i++)
        {
            ArrayList<Integer> new_list = new ArrayList<Integer>();
            result.add(new_list);
        }

        // insert the nodes to the arraylist
        populate_result(root, result, 0);

        return result;
    }

    // insert the nodes to the list at the target level
    public void populate_result(TreeNode node, ArrayList<ArrayList<Integer>> result, int idx)
    {
        if(node == null)
        {
            return;
        }

        ArrayList<Integer> target_list = result.get(idx);
        target_list.add(node.val);

        populate_result(node.left, result, idx+1);
        populate_result(node.right, result, idx+1);
        
    }

    public int get_num_levels(TreeNode root)
    {
        int result = 0;
        if(root != null)
        {
            result = trace_deep(root, 1);
        }

        return result;
    }

    public int trace_deep(TreeNode root, int level)
    {
        if(root == null)
        {
            return level;
        }
        else
        {
            int left_level = 0;
            int right_level = 0;
            if(root.left != null)
            {
                left_level = trace_deep(root.left, level+1);
            }

            if(root.right != null)
            {
                right_level = trace_deep(root.right, level+1);
            }

            if(left_level > level)
            {
                level = left_level;
            }
            if(right_level > level)
            {
                level = right_level;
            }

            return level;
        }
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


