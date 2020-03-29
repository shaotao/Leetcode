import java.io.*;
import java.util.*;


class TwoSum4
{
    public static void main(String[] args)
    {
	System.out.println("=== Two Sum 4 ===");
	Solution solution = new Solution();
        TreeNode root = buildTree();
        int k = 9;

        System.out.println("k = "+k);
        System.out.println("find target: "+solution.findTarget(root, k));
    }

    public static TreeNode buildTree() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n5.left = n3; n5.right = n6;
        n3.left = n2; n3.right = n4;
        n6.right = n7;
        return n5;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution
{
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        trace(root, map);

        for (int key : map.keySet()) {
            if (k == 2*key) { return false; }
            if (map.containsKey(k-key)) {
                return true;
            }
        }
        
        return false;
    }

    private void trace(TreeNode root, Map<Integer, Integer> map) {
        if (root == null || map == null) { return; }

        map.put(root.val, 1);
        trace(root.left, map);
        trace(root.right, map);
    }
}
