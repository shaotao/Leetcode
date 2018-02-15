import java.io.*;
import java.util.*;


class MinimumDistanceBetweenBSTNodes
{
    public static void main(String[] args)
    {
        System.out.println("=== Minimum Distance Between BST Nodes ===");
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n4.left = n2; n4.right = n6;
        n2.left = n1; n2.right = n3;

        int minDiff = solution.minDiffInBST(n4);
        System.out.println("minDiff = "+minDiff);
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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        serialize(root, list);
        int minGap = -1;
        for(int i = 0; i < list.size()-1; i++) {
            int gap = list.get(i+1) - list.get(i);
            minGap = (minGap == -1 || minGap > gap)?gap:minGap;
        }

        return minGap;
    }

    private void serialize(TreeNode root, List<Integer> list) {
        if(root == null) { return; }
        else {
            serialize(root.left, list);
            list.add(root.val);
            serialize(root.right, list);
        }
    }
}
