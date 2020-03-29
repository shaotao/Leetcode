import java.io.*;
import java.util.*;


class PrintBinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== print binary tree===");
        Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2; n1.right = n5;
        n2.left = n3; n3.left = n4;

        System.out.println("binary tree: "+solution.printTree(n1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { this.val = x; }
}

class Solution
{
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<List<String>>();
        
        int rows = height(root);
        int cols = (int)Math.pow(2, rows)-1;
        String[][] array = new String[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                array[i][j] = "";
            }
        }

        trace(root, array, 1, 0, cols-1);

        for(String[] row:array) {
            ret.add(Arrays.asList(row));
        }

        return ret;
    }

    private void trace(TreeNode root, String[][] array, int height, int left, int right) {
        if(root == null || right < left) { return; }
        int pos = (left+right)/2;
        array[height-1][pos] = Integer.toString(root.val);
        trace(root.left, array, height+1, left, pos-1);
        trace(root.right, array, height+1, pos+1, right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = height(root.left);
            int right = height(root.right);
            return (left>right)?(left+1):(right+1);
        }
    }
}
