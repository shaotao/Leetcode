import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}


class BinaryTreeRightSideView
{
    public static void main(String[] args)
    {
        System.out.println("=== Binary Tree Right Side View ===");
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;
        n3.right = n4;

        List<Integer> list = solution.rightSideView(n1);
        System.out.print("list: ");
        for(Integer n : list) {
            System.out.print(n+", ");
        }
        System.out.println();
    }
}

class Solution
{
    // breath first scan of a tree
    public List<Integer> rightSideView(TreeNode root)
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        if(root == null) { return ret; }
        
        // we use null as the mark for end of a level
        list.add(root);
        list.add(null);
        TreeNode prev = null;
        while(list.size() > 0) {
            TreeNode n = list.remove(0);
            if(n == null) { 
                ret.add(prev.val);
                // if this is end of one level, we have more level, add null
                if(list.size() > 0) { list.add(null); }
            } else {
                if(n.left != null) { list.add(n.left); }
                if(n.right != null) { list.add(n.right); }
            }

            prev = n;
        }

        return ret;
    }
}
