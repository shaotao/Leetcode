import java.io.*;
import java.util.*;

class KthSmallestElementInABST
{
    public static void main(String[] args)
    {
        System.out.println("=== Keth Smallest Element in a BST ===");
        Solution solution = new Solution();

        int num = 10;
        TreeNode root = build_bst();

        printTree(root);

        for(int i = 1; i <= num; i++) {
            int ret = solution.kthSmallest(root, i);
            System.out.println(i+"th smallest: "+ret);
        }
    }

    public static void printTree(TreeNode root) {
        if(root == null) { return;}
        System.out.println(root.val+":("+((root.left != null)?root.left.val:null)+","+((root.right != null)?root.right.val:null)+")");
        printTree(root.left);
        printTree(root.right);
    }

    // build a bst with 10 nodes: 1 - 10
    public static TreeNode build_bst() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);

        n5.left = n3;
        n5.right = n8;
        n3.left = n2;
        n3.right = n4;
        n2.left = n1;
        n8.left = n7;
        n8.right = n9;
        n7.left = n6;
        n9.right = n10;
        
        return n5;
    }
    
    public static TreeNode build_tree(int n) {
        if(n <= 0) { return null; }
        
        TreeNode[] nodes = new TreeNode[n];
        for(int i = 0; i <n; i++) {
            nodes[i] = new TreeNode(i+1);
        }

        // link the nodes up
        int parent_idx = 0;
        int child_idx = 1;
        while(parent_idx < n && child_idx < n) {
            TreeNode parent = null;
            TreeNode child = null;
            if(parent_idx < n) {
                parent = nodes[parent_idx];
            } else { break; }

            if(child_idx < n) {
                parent.left = nodes[child_idx];
            } else { break; }
            child_idx++;

            if(child_idx < n) {
                parent.right = nodes[child_idx];
            } else { break; }
            child_idx++;

            parent_idx++;
        }
        
        return nodes[0];
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution
{
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) { return 0; }
        
        // serialize the BST tree first in ascending order
        ArrayList<Integer> list = new ArrayList<Integer>();
        serializeTree(root, list);
        
        return list.get(k-1);
    }

    public void serializeTree(TreeNode root, ArrayList<Integer> list) {
        if(root == null || list == null) { return; }

        serializeTree(root.left, list);
        list.add(root.val);
        serializeTree(root.right, list);
    }
}
