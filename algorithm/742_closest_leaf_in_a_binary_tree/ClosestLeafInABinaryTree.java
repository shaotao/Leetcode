import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


class ClosestLeafInABinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Closest Leaf in a Binary Tree ===");
        Solution solution = new Solution();
        TreeNode[] array = new TreeNode[6];
        IntStream.range(0, 6).forEach(i -> array[i] = new TreeNode(i+1));
        array[0].left = array[1]; array[0].right = array[2];
        array[1].left = array[3]; array[3].left = array[4];
        array[4].left = array[5];
        System.out.println(Arrays.toString(array));
        System.out.println("closest leaf = "+solution.findClosestLeaf(array[0], 3));
    }
}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public String toString() {
        String str = String.format("tree(val=%s, left=%s, right=%s)", val, left==null?null:left.val, right==null?null:right.val);
        return str;
    }
}

class Solution
{
    public int findClosestLeaf(TreeNode root, int k) {
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        TreeNode n = findTreeNode(root, k, path1);

        List<TreeNode> path2 = new ArrayList<TreeNode>();
        List<List<TreeNode>> paths = new ArrayList<>();
        findLeaves(root, path2, paths);

        //System.out.println("n = "+n);
        //System.out.println("path = "+path1);

        //paths.stream().forEach(p -> System.out.println(p));

        List<TreeNode> minPath = null;
        int minDist = -1;
        TreeNode nbr = null;
        for (List<TreeNode> p : paths) {
            int dist = dist(path1, p);
            if(dist != -1) {
                if(minDist == -1 || minDist > dist) {
                    minDist = dist;
                    nbr = p.get(p.size()-1);
                }
            }
        }

        return nbr.val;
    }

    private int dist(List<TreeNode> p1, List<TreeNode> p2) {
        if(p1 == null || p2 == null) {
            return -1;
        }

        int i = 0;
        int common = 0;
        while(i < p1.size() && i < p2.size()) {
            if (p1.get(i).val == p2.get(i).val) {
                common++;
            } else {
                break;
            }
            i++;
        }

        return p1.size() + p2.size() - 2*common;
    }

    private void findLeaves(TreeNode root, List<TreeNode> path, List<List<TreeNode>> paths) {
        if (root == null) {
            return;
        }

        path.add(root);
        int size = path.size();
        if (root.left == null && root.right == null) {
            paths.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }

        if(root.left != null) {
            findLeaves(root.left, path, paths);
        }

        path = path.subList(0, size);

        if(root.right != null) {
            findLeaves(root.right, path, paths);
        }
    }

    private TreeNode findTreeNode(TreeNode root, int k, List<TreeNode> path) {
        if (root == null) {
            return null;
        }

        path.add(root);
        if (root.val == k) { return root; }
        TreeNode fromLeft = findTreeNode(root.left, k, path);
        if (fromLeft != null) {
            return fromLeft;
        } 

        TreeNode fromRight = findTreeNode(root.right, k, path);
        if (fromRight != null) {
            return fromRight;
        }

        path.remove(path.size()-1);
        return null;
    }
}
