import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class MostFrequentSubtreeSum
{
    public static void main(String[] args)
    {
	System.out.println("=== Most Frequent Subtree Sum ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(-3);
        n1.left = n2; n1.right = n3;
        
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(-5);
        n4.left = n5; n4.right = n6;

        System.out.println("ret = "+Arrays.toString(solution.findFrequentTreeSum(n1)));
        System.out.println("ret = "+Arrays.toString(solution.findFrequentTreeSum(n4)));
    }
}


class Solution
{
    public int[] findFrequentTreeSum(TreeNode root) {
        int[] ret = null;

        if(root == null) { return new int[0]; }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] maxCount = new int[1]; maxCount[0] = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        scanTree(root, map, maxCount, list);

        ret = new int[list.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = list.get(i);
        }
        
        return ret;
    }

    public void addVal(HashMap<Integer, Integer> map, int val, int[] maxCount, ArrayList<Integer> list) {
        int count = 1;
        if(map.containsKey(val)) { count += map.get(val); }
        if(count > maxCount[0]) { maxCount[0] = count; list.clear(); list.add(val); }
        else if(count == maxCount[0]) { list.add(val); }
        map.put(val, count);
    }
    
    public int scanTree(TreeNode n, HashMap<Integer, Integer> map, int[] maxCount, ArrayList<Integer> list) {
        int val = n.val;
        if(n.left != null) { val += scanTree(n.left, map, maxCount, list); }
        if(n.right != null) { val += scanTree(n.right, map, maxCount, list); }
        addVal(map, val, maxCount, list);

        return val;
    }
}
