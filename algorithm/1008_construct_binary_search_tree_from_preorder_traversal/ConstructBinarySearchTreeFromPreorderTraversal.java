import java.io.*;
import java.util.*;


class ConstructBinarySearchTreeFromPreorderTraversal
{
    public static void main(String[] args)
    {
        System.out.println("=== Construct Binary Search Tree from Preorder Traversal ===");
        Solution solution = new Solution();

        int[] preorder = {8,5,1,7,10,12};

        TreeNode root = solution.bstFromPreorder(preorder);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) { return; }
        System.out.println("n = "+root.val);
        System.out.println("n.left = "+(root.left==null?null:root.left.val));
        System.out.println("n.right = "+(root.right==null?null:root.right.val));
        printTree(root.left);
        printTree(root.right);
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { this.val = x; }
}

class Solution
{
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        Stack<TreeNode> stack = new Stack<>();
        for (int i : preorder) {
            TreeNode n = new TreeNode(i);
            if (root == null) {
                root = n;
            } else {
                if (n.val < stack.peek().val) {
                    stack.peek().left = n;
                } else {
                    TreeNode top = null;
                    while (stack.size() > 0 && stack.peek().val < n.val) {
                        top = stack.pop();
                    }
                    top.right = n;
                }
            }
            stack.push(n);
        }

        return root;
    }
}
