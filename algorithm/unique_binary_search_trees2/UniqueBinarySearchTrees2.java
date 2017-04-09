import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; left = null; right = null; }
}


class UniqueBinarySearchTrees2
{
    public static void main(String[] args)
    {
        System.out.println("=== Unique Binary Search Trees 2 ===");
        Solution solution = new Solution();
        
        int n = 3;
        ArrayList<TreeNode> result = solution.generateTrees(n);
        
        System.out.println("n = "+n);
        System.out.println("# of trees = "+result.size());
        for(int i = 0; i < result.size(); i++)
        {
            System.out.print((i+1)+") ");
            print_tree(result.get(i));
        }
    }
    
    public static void print_tree(TreeNode root)
    {
        StringBuffer ret = new StringBuffer("");
        LinkedList<TreeNode> l1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> l2 = new LinkedList<TreeNode>();
        
        if(root != null) { l1.add(root); }
        while(l1.size() > 0)
        {
            TreeNode node = l1.pop();
            l2.add(node);
            
            if(node != null) { l1.add(node.left); l1.add(node.right); }
        }
        
        // trim the trailing nulls
        for(int i = l2.size()-1; i >= 0; i--)
        {
            if(l2.get(i) == null) { l2.remove(i); }
            else { break; }
        }
        
        ret.append("{");
        if(l2.size() > 0) { ret.append(l2.get(0).val); }
        for(int i = 1; i < l2.size(); i++)
        {
            ret.append(",");
            if(l2.get(i) == null)
            {
                ret.append("#");
            }
            else
            {
                ret.append(l2.get(i).val);
            }
        }
        ret.append("}");

        System.out.println("the tree is: "+ ret.toString());
    }
}


class Solution
{
    public ArrayList<TreeNode> generateTrees(int n)
    {
        ArrayList<TreeNode> result = build_trees(1, n);
        
        return result;
    }
    
    public ArrayList<TreeNode> build_trees(int start, int n)
    {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();

        if(n <= 0) { ret.add(null); return ret; };

        for(int i = start; i < start+n; i++)
        {
            ArrayList<TreeNode> left_list = build_trees(start, i -start); 
            ArrayList<TreeNode> right_list = build_trees(i+1, (start+n-1)-i);
            
            for(int t1 = 0; t1 < left_list.size(); t1++)
            {
                for(int t2 = 0; t2 < right_list.size(); t2++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left_list.get(t1);
                    root.right = right_list.get(t2);
                    ret.add(root);
                }
            }
        }
        
        return ret;
    }
}