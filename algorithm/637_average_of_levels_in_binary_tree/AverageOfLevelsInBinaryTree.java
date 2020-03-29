import java.io.*;
import java.util.*;


class AverageOfLevelsInBinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Average of Levels in Binary Tree ===");
        Solution solution = new Solution();
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n3.left = n9; n3.right = n20;
        n20.left = n15; n20.right = n7;

        List<Double> list = solution.averageOfLevels(n3);
        System.out.println("average = "+list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { this.val = x; }
}

class Pair {
    private long count;
    private long sum;
    public Pair(long count, long sum) {
        this.count = count;
        this.sum = sum;
    }

    public void add(int val) {
        count++;
        sum += val;
    }

    public double getAvg() {
        return 1.0*sum/count;
    }
}

class Solution
{
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Long, Pair> map = new HashMap<>();
        trace(root, map, 0);
        List<Long> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        List<Double> ret = new ArrayList<>();

        for (Long key : keys) {
            ret.add(map.get(key).getAvg());
        }
        
        return ret;
    }

    private void trace(TreeNode node, Map<Long, Pair> map, long level) {
        if (node == null) { return; }

        Pair pair = map.get(level);
        if(pair == null) {
            pair = new Pair(1, node.val);
            map.put(level, pair);
        } else {
            pair.add(node.val);
        }
        
        trace(node.left, map, level+1);
        trace(node.right, map, level+1);
    }
}
