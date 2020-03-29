import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class SubtreeOfAnotherTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Subtree of Another Tree ===");
	Solution solution = new Solution();

        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        TreeNode s0 = new TreeNode(0);

        s4.left = s1; s4.right = s2;
        s3.left = s4; s3.right = s5;

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);

        t4.left = t1; t4.right = t2;

        System.out.println("subtree = "+solution.isSubtree(s3, t4));

        s2.left = s0;

        System.out.println("subtree = "+solution.isSubtree(s3, t4));
    }
}


class Solution
{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        findTreeNode(s, t, nodes);

        for(TreeNode node : nodes) {
            if(equalTree(node, t)) {
                return true;
            }
        }

        return false;
    }

    private boolean equalTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) { return true; }
        else if(s == null && t != null) { return false; }
        else if(s != null && t == null) { return false; }

        if(s.val != t.val) { return false; }

        return equalTree(s.left, t.left) && equalTree(s.right, t.right);
    }

    private void findTreeNode(TreeNode root, TreeNode target, List<TreeNode> nodes) {
        if(root == null || target == null) { return; }

        if(root.val == target.val) { nodes.add(root); }
        findTreeNode(root.left, target, nodes);
        findTreeNode(root.right, target, nodes);
    }
}
