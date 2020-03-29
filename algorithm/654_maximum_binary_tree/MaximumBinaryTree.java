import java.io.*;
import java.util.*;


class MaximumBinaryTree
{
    public static void main(String[] args)
    {
	System.out.println("=== 654. Maximum Binary Tree ===");
	Solution solution = new Solution();
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = solution.constructMaximumBinaryTree(nums);
        print_tree(root);
    }

    public static void print_tree(TreeNode root) {
        if(root == null) { return; }
        System.out.println(String.format("%s(%s, %s)",
                                         root.val,
                                         root.left==null?null:root.left.val,
                                         root.right==null?null:root.right.val)
            );
        print_tree(root.left);
        print_tree(root.right);
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findRoot(nums, 0, nums==null?-1:nums.length-1);
    }

    private TreeNode findRoot(int[] nums, int left, int right) {
        if(nums == null || left < 0 || right >= nums.length || right < left) {
            return null;
        }

        int maxIdx = left;
        int max = nums[left];
        for(int i = left; i <= right; i++) {
            if(nums[i] > max) {
                maxIdx = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = findRoot(nums, left, maxIdx-1);
        root.right = findRoot(nums, maxIdx+1, right);
        
        return root;
    }
}
