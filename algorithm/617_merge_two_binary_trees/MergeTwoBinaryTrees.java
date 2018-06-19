import java.io.*;
import java.util.*;


class MergeTwoBinaryTrees
{
    public static void main(String[] args)
    {
        System.out.println("=== Merge Two Binary Trees ===");
        Solution solution = new Solution();

        TreeNode a1 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode a5 = new TreeNode(5);
        a1.left = a3;
        a1.right = a2;
        a3.left = a5;

        TreeNode b2 = new TreeNode(2);
        TreeNode b1 = new TreeNode(1);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b7 = new TreeNode(7);
        b2.left = b1; b2.right = b3;
        b1.right = b4;
        b3.right = b7;

        TreeNode ret = solution.mergeTrees(a1, b2);
        System.out.println("Tree 1");
        printTree(a1);

        System.out.println("Tree 2");
        printTree(b2);

        System.out.println("Merged tree");
        printTree(ret);
    }

    public static void printTree(TreeNode node) {
        if(node == null) { return; }
        System.out.println(node.val+":("+((node.left==null)?null:node.left.val)+", "+ ((node.right==null)?null:node.right.val)+")");
        printTree(node.left);
        printTree(node.right);
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode node = new TreeNode( (t1==null?0:t1.val) + (t2==null?0:t2.val) );
        node.left = mergeTrees(t1==null?null:t1.left, t2==null?null:t2.left);
        node.right = mergeTrees(t1==null?null:t1.right, t2==null?null:t2.right);

        return node;
    }
}
