import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString() { return String.format("node(%d)", val); }
}

public class FindLargestValueInEachTreeRow
{
    public static void main(String[] args)
    {
	System.out.println("=== Find Largest Value in Each Tree Row ===");
	Solution solution = new Solution();
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(9);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        List<Integer> list = solution.largestValues(n1);
        System.out.println("largest values = "+list);
    }
}


class Solution
{
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();

        List<TreeNode> slist = new ArrayList<TreeNode>();

        // serialize the binary tree, row by row, end by null per row.
        slist.add(root);
        slist.add(null);
        TreeNode prev = null;
        for(int i = 0; i < slist.size(); i++) {
            TreeNode n = slist.get(i);
            if(n!=null) {
                if(n.left != null) { slist.add(n.left); }
                if(n.right != null) { slist.add(n.right); }
            } else if(prev != null) {
                slist.add(null);
            }

            prev = n;
        }

        //System.out.println("slist = "+slist);

        // get the max for each row
        Integer max = null;
        for(int i = 0; i < slist.size(); i++) {
            TreeNode n = slist.get(i);
            if(n!= null && (max == null || n.val > max)) { max = n.val; }
            if(n == null && max != null) { ret.add(max); max = null; }
        }
        
        return ret;
    }
}
