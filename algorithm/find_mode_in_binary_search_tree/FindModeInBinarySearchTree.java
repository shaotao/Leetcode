import java.io.*;
import java.util.*;


class FindModeInBinarySearchTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Find Mode in Binary Search Tree ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.right = n2;
        //n2.left = n3;

        System.out.println("mode = "+Arrays.toString(solution.findMode(n1)));
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        left = null;
        right = null;
    }
}

class Solution
{
    public int[] findMode(TreeNode root) {

        if(root == null) {
            return new int[0];
        }
        
        List<Integer> list = new ArrayList<Integer>();

        int[] val = new int[1]; val[0] = root.val;
        int[] count = new int[1]; count[0] = 0;
        int[] max = new int[1]; max[0] = 0;

        inOrder(root, val, count, max, list);

        int[] ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    private void inOrder(TreeNode n, int[] val, int[] count, int[] max, List<Integer> list) {
        if(n == null) { return; }
        inOrder(n.left, val, count, max, list);

        if(n.val == val[0]) {
            count[0]++;
        } else {
            val[0] = n.val;
            count[0] = 1;            
        }

        if(count[0] == max[0]) {
            list.add(n.val);
        } else if(count[0] > max[0]) {
            list.clear();
            list.add(n.val);
            max[0] = count[0];
        }

        inOrder(n.right, val, count, max, list);
    }
}
