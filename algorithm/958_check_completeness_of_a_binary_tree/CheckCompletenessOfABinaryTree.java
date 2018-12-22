import java.io.*;
import java.util.*;


class CheckCompletenessOfABinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Check Completeness of a Binary Tree ===");
        Solution solution = new Solution();

        TreeNode root = buildTree();
        System.out.println("is complete tree = "+solution.isCompleteTree(root));
    }

    private static TreeNode buildTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.right = n7;
        return n1;
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }
}

class Solution
{
    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> list = bfs(root);
        int countNull = 0;
        for (TreeNode n : list) {
            if (n == null) {
                countNull++;
            } else if (countNull > 0) {
                return false;
            }
        }
        return true;
    }

    private List<TreeNode> bfs(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        int idx = 0;
        while (idx < list.size()) {
            TreeNode n = list.get(idx);
            if (n != null) {
                list.add(n.left);
                list.add(n.right);
            }
            idx++;
        }

        return list;
    }
}

