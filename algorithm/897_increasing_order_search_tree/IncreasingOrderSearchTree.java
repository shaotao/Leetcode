import java.io.*;
import java.util.*;


class IncreasingOrderSearchTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Increasing Order Search Tree ===");
        Solution solution = new Solution();
        TreeNode root = buildTree();
        System.out.println("input:");
        printTree(root);
        TreeNode ret = solution.increasingBST(root);
        System.out.println("increasing order:");
        printTree(ret);
    }

    public static TreeNode buildTree() {
        int num = 9;
        TreeNode[] nodes = new TreeNode[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new TreeNode(i+1);
        }

        nodes[4].left = nodes[2]; nodes[4].right = nodes[5];
        nodes[2].left = nodes[1]; nodes[2].right = nodes[3];
        nodes[1].left = nodes[0];
        nodes[5].right = nodes[7];
        nodes[7].left = nodes[6];
        nodes[7].right = nodes[8];
        
        return nodes[4];
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.val+":("+
                               (root.left==null?"null":root.left.val)+
                               ","+(root.right==null?"null":root.right.val)+")");
            printTree(root.left);
            printTree(root.right);
        }
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution
{
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        toList(root, list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = null;
            list.get(i).right = (i < list.size()-1)?list.get(i+1):null;
        }
        return list.get(0);
    }

    public void toList(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        toList(root.left, list);
        list.add(root);
        toList(root.right, list);
    }
}
