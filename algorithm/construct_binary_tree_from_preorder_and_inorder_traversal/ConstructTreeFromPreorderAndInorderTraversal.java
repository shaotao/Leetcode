import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) { val = x; left = null; right = null; }
}


class ConstructTreeFromPreorderAndInorderTraversal
{
    public static void main(String[] args)
    {
        System.out.println("== Construct Tree From Preorder and Inorder Traversal ===");

        Solution solution = new Solution();
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};

        TreeNode ret = solution.buildTree(preorder, inorder);
        
        System.out.print("preorder = ");
        print_array(preorder);

        System.out.print("inorder = ");
        print_array(inorder);

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
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        TreeNode ret = build_tree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return ret;
    }

    public TreeNode build_tree(int[] a1, int[] a2, int a1_s, int a1_e, int a2_s, int a2_e)
    {
        if(a1_s > a1_e) { return null; }
        else if(a1_s == a1_e) { return new TreeNode(a1[a1_s]); }
        else
        {
            TreeNode node = new TreeNode(a1[a1_s]);
            int a2_idx = a2_s;
            for(a2_idx = a2_s; a2_idx <= a2_e; a2_idx++)
            {
                if(a2[a2_idx] == a1[a1_s]) { break; }
            }
            
            TreeNode left = build_tree(a1, a2, a1_s+1, a1_s+(a2_idx-a2_s), a2_s, a2_idx-1);
            TreeNode right = build_tree(a1, a2, a1_s+1+(a2_idx-a2_s), a1_e, a2_idx+1, a2_e);
            
            node.left = left;
            node.right = right;
            
            return node;
        }
    }
}