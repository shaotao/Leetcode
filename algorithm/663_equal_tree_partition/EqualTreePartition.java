import java.io.*;
import java.util.*;


class EqualTreePartition
{
    public static void main(String[] args)
    {
        System.out.println("=== Equal Tree Partition ===");
        Solution solution = new Solution();
        TreeNode root = createTree();
        System.out.println(solution.checkEqualTree(root)); 
    }

    public static TreeNode createTree() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(10); 
        TreeNode n3 = new TreeNode(10); 
        TreeNode n4 = new TreeNode(2); 
        TreeNode n5 = new TreeNode(3); 
        n1.left = n2; n1.right = n3;
        n3.left= n4; n3.right = n5;
        return n1;
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}


class Solution
{
    public boolean checkEqualTree(TreeNode root) {
        Map<Long, Long> map = new HashMap<Long, Long>();
        long total = trace(root, map);
        if(total%2!=0) { return false; }
        long half = total/2;
        if(!map.containsKey(half)) { return false; }
        return (half == total)?(map.get(half) > 1):true;
    }

    private long trace(TreeNode root, Map<Long, Long> map) {
        if(root == null) { return 0; }
        long sum = root.val + trace(root.left, map) + trace(root.right, map);
        long count = map.containsKey(sum)?map.get(sum)+1:1;
        map.put(sum, count);
        return sum;
    }
}
