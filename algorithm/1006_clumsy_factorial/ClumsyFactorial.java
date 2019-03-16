import java.io.*;
import java.util.*;


class ClumsyFactorial
{
    public static void main(String[] args)
    {
        System.out.println("=== Clumsy Factorial ===");
        Solution solution = new Solution();

        int[] input = {4, 10};
        for (int N : input) {
            System.out.println("input N = "+N+", clumsy factorial = "+solution.clumsy(N));
        }
    }
}

class TreeNode
{
    String op;
    Integer val;
    TreeNode left;
    TreeNode right;
    public TreeNode(String op, Integer val) {
        this.op = op;
        this.val = val;
    }
}

class Solution
{
    private static final String[] ops = {"-", "*", "/", "+"};
    public int clumsy(int N) {
        int ret = 0;

        TreeNode root = null;
        TreeNode prev = null;
        for (int i = N; i >= 1;i--) {
            String op = ops[(N-i)%4];

            TreeNode opNode = new TreeNode(op, null);
            TreeNode numNode = new TreeNode(null, i);

            if (root == null) {
                root = numNode;
                prev = root;
            } else {
                if (op.equals("*") || op.equals("/")) {
                    opNode.left = prev;
                    opNode.right = numNode;
                    prev = opNode;
                    if (N-i <= 2) {
                        root = opNode;
                    } else {
                        root.right = opNode;
                    }
                } else {
                    opNode.left = root;
                    opNode.right = numNode;
                    root = opNode;
                    prev = numNode;
                }
            }
        }

        return compute(root);
    }

    public int compute(TreeNode root) {
        if (root.val != null) { return root.val; }
        else {
            if (root.op.equals("*")) {
                return compute(root.left)*compute(root.right);
            } else if (root.op.equals("/")) {
                return compute(root.left)/compute(root.right);
            } else if (root.op.equals("+")) {
                return compute(root.left)+compute(root.right);
            } else {
                return compute(root.left)-compute(root.right);
            }
        }
    }
}
