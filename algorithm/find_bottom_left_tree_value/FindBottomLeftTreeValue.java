import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString() { return Integer.toString(val); }
}

class FindBottomLeftTreeValue
{
    public static void main(String[] args)
    {
	System.out.println("=== Find Bottom Left Tree Value ===");
	Solution solution = new Solution();

        TreeNode[] nodes = new TreeNode[7];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i+1);
        }

        nodes[0].left = nodes[1]; nodes[0].right = nodes[2];
        nodes[1].left = nodes[3];
        nodes[2].left = nodes[4]; nodes[2].right = nodes[5];
        nodes[4].left = nodes[6];
        
        int ret = solution.findBottomLeftValue(nodes[0]);
        System.out.println("bottom left value = "+ret);
    }
}


class Solution
{
    // serialize the tree and find the last row
    public int findBottomLeftValue2(TreeNode root) {
        int ret = 0;

        // serialize the tree into a list
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        if(root == null) { return -1; }
        list.add(root); list.add(null);

        TreeNode prev = null;
        for(int i = 0; i < list.size(); i++) {
            TreeNode n = list.get(i);
            if(n != null) {
                if(prev == null) { ret = n.val; }
                if(n.left != null) { list.add(n.left); }
                if(n.right != null) { list.add(n.right); }
            } else if(prev != null) {
                list.add(null);
            }
            
            prev = n;
        }

        return ret;
    }

    // recusion, depth first search
    public int findBottomLeftValue(TreeNode root) {
        int[] deepest = {0};
        int[] val = {-1};

        search(root, 1, deepest, val);
        
        return val[0];
    }

    public void search(TreeNode n, int level, int[] deepest, int[] val) {
        if(level > deepest[0]) {
            deepest[0] = level;
            val[0] = n.val;
        }

        if(n.left != null) { search(n.left, level+1, deepest, val); }
        if(n.right != null) { search(n.right, level+1, deepest, val); }
    }
}
