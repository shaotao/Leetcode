import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) { val = x; left = null; right = null; }
}


class ConstructTreeFromInorderAndPostorderTraversal
{
    public static void main(String[] args)
    {
        System.out.println("== Construct Tree From Inorder and Postorder Traversal ===");

        Solution solution = new Solution();
        int[] inorder = {4,2,5,1,6,3,7};
        int[] postorder = {4,5,2,6,7,3,1};

        TreeNode ret = solution.buildTree(inorder, postorder);
        
        System.out.print("inorder = ");
        print_array(inorder);

        System.out.print("postorder = ");
        print_array(postorder);

        print_tree(ret);
    }

    public static void print_array(int[] a)
    {
        if(a.length <= 0)
        {
            return;
        }

        System.out.print(a[0]);
        for(int i = 1; i < a.length; i++)
        {
            System.out.print(","+a[i]);
        }
        System.out.println();
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
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        TreeNode ret = build_tree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        return ret;
    }

    public TreeNode build_tree(int[] a1, int[] a2, int a1_s, int a1_e, int a2_s, int a2_e)
    {
        if(a2_s > a2_e) { return null; }
        else if(a2_s == a2_e) { return new TreeNode(a2[a2_e]); }
        else
        {
            TreeNode node = new TreeNode(a2[a2_e]);
            int a1_idx = a1_s;
            for(a1_idx = a1_s; a1_idx <= a1_e; a1_idx++)
            {
                if(a1[a1_idx] == a2[a2_e]) { break; }
            }
            
            TreeNode left = build_tree(a1, a2, a1_s, a1_idx-1, a2_s, a2_s+(a1_idx-a1_s)-1);
            TreeNode right = build_tree(a1, a2, a1_idx+1, a1_e, a2_s+(a1_idx-a1_s), a2_e-1);
            
            node.left = left;
            node.right = right;
            
            return node;
        }
    }
}