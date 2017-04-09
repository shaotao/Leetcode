import java.io.*;
import java.util.*;


class InvertBinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Invert Binary Tree ===");
        Solution solution = new Solution();
        
        TreeNode[] nodes = new TreeNode[9];
        for(int i = 1; i <=9; i++) {
            nodes[i-1] = new TreeNode(i);
        }

        nodes[3].left = nodes[1];
        nodes[3].right = nodes[6];
        nodes[1].left = nodes[0];
        nodes[1].right = nodes[2];
        nodes[6].left = nodes[5];
        nodes[6].right = nodes[8];

        System.out.println("original tree:");
        print_tree(nodes[3]);
        TreeNode root = solution.invertTree(nodes[3]);
        System.out.println("after inversion:");
        print_tree(root);
    }

    public static void print_tree(TreeNode root) {
        if(root == null) { return; }
        System.out.println(root.val+": left="+((root.left==null)?null:(root.left.val))+", right = "+((root.right == null)?null:(root.right.val)));
        print_tree(root.left);
        print_tree(root.right);
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class Solution
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null) { return root; }
        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
