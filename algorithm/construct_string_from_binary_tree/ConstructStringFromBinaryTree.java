import java.io.*;
import java.util.*;


class ConstructStringFromBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Construct String From Binary Tree ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = null;
        System.out.println("str = "+solution.tree2str(n1));

        n1.left = n2; n1.right = n3;
        n2.left = null; n2.right = n4;
        System.out.println("str = "+solution.tree2str(n1));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution
{
    public String tree2str(TreeNode t) {
        StringBuffer buf = new StringBuffer();
        trace(t, buf);
        return buf.toString();
    }

    public void trace(TreeNode root, StringBuffer buf) {
        if(root == null || buf == null) { return; }

        buf.append(root.val);
        if(root.left == null) {
            if(root.right != null) {
                buf.append("()(");
                trace(root.right, buf);
                buf.append(")");
            }
        } else {
            buf.append("(");
            trace(root.left, buf);
            buf.append(")");
            if(root.right != null) {
                buf.append("(");
                trace(root.right, buf);
                buf.append(")");                
            }
        }
    }
}
