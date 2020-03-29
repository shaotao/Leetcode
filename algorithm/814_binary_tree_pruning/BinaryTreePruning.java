import java.io.*;
import java.util.*;


class BinaryTreePruning
{
    public static void main(String[] args)
    {
        System.out.println("=== 814. Binary Tree Pruning ===");
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(0);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        n4.left = n8;
        System.out.println("=== before pruning ===");
        printTree(n1);

        n1 = solution.pruneTree(n1);
        
        System.out.println("=== after pruning ===");
        printTree(n1);
    }

    private static void printTree(TreeNode root) {
        if(root == null) { return; }
        System.out.println(root.val+"("+(root.left==null?null:root.left.val)+","+(root.right==null?null:root.right.val)+")");
        printTree(root.left);
        printTree(root.right);
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
    public TreeNode pruneTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        count(root, map);

        trace(root, map);
        
        return root;
    }

    private void trace(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) { return; }
        if (node.left != null && map.get(node.left) == 0) {
            node.left = null;
        } else {
            trace(node.left, map);
        }

        if (node.right != null && map.get(node.right) == 0) {
            node.right = null;
        } else {
            trace(node.right, map);
        }
    }

    private int count(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }

        int ret = node.val + count(node.left, map) + count(node.right, map);
        map.put(node, ret);
        return ret;
    }
}
