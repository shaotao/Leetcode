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


class BTreeInorder
{
    public static void main(String[] args)
    {
        String[] array = {"3", "4", "#", "#", "2", "#", "1"};
        Solution solution = new Solution();

        TreeNode root = solution.create_tree(array);

        solution.print_tree(root);

        //ArrayList<Integer> result = solution.inorderTraversal(root);
        ArrayList<Integer> result = solution.inorderTraversal2(root);
        System.out.println(result);
    }

}

class Solution
{
    // method-1: recursive
    public ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root != null)
        {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }

    // method-2: iterative
    public ArrayList<Integer> inorderTraversal2(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        TreeNode node = root;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(node != null)
        {
            stack.push(node);
            node = node.left;
        }

        while(stack.empty() == false)
        {
            node = stack.pop();
            result.add(node.val);

            // check right
            if(node.right != null)
            {
                node = node.right;
                stack.push(node);

                while(node.left != null)
                {
                    node = node.left;
                    stack.push(node);
                }
            }
        }

        return result;

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


