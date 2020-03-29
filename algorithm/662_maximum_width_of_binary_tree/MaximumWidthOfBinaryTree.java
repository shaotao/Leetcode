import java.io.*;
import java.util.*;
import java.lang.reflect.*;


class MaximumWidthOfBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Maximum Width of Binary Tree ===");
	Solution solution = new Solution();
        TreeNode root = buildTree();
        System.out.println("width = "+solution.widthOfBinaryTree(root));
    }

    public static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n33 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        n1.left = n3; n1.right = n2;
        n3.left = n5; n3.right = n33;
        n2.right = n9;
        return n1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Range {
    Integer left;
    Integer right;

    public Range(int x) {
        left = new Integer(x);
        right = new Integer(x);
    }
    
    public void put(int x) {
        if(left.intValue() > x) { left = new Integer(x); }
        if(right.intValue() < x) { right = new Integer(x); }
    }

    // width from left to right inclusive
    public int getWidth() {
        return right-left+1;
    }
}

class Solution
{
    public int widthOfBinaryTree(TreeNode root) {
        // level -> range
        Map<Integer, Range> map = new HashMap<>();

        trace(root, map, 0, 0, 0);
        int max = 0;
        for(Integer key : map.keySet()) {
            Range range = map.get(key);
            if(range.getWidth() > max) {
                max = range.getWidth();
            }
        }

        return max;
    }

    // level = 0 for root, dir=0 -> left child, dir=1 -> right child
    private void trace(TreeNode n, Map<Integer, Range> map, int level, int pval, int dir) {
        if(n == null) { return; }
        
        int val = 2*pval + dir;
        
        Range range = map.get(level);
        if(range == null) {
            range = new Range(val);
            map.put(level, range);
        } else {
            range.put(val);
        }

        trace(n.left, map, level+1, val, 0);
        trace(n.right, map, level+1, val, 1);
    }
}
