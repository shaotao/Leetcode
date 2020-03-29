import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ConvertBSTToGreaterTree
{
    public static void main(String[] args)
    {
	System.out.println("=== Convert BST to Greater Tree ===");
	Solution solution = new Solution();

        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(13);
        n1.left = n2;
        n1.right = n3;

        printTree(n1);
        TreeNode ret = solution.convertBST(n1);
        printTree(ret);
    }

    public static void printTree(TreeNode root) {
        if(root == null) { return; }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }
}


class Solution
{
    public TreeNode convertBST(TreeNode root) {
        if(root == null) { return root; }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        toList(root, list);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();;
        int sum = 0;
        for(int i = list.size()-1; i >= 0; i--) {
            sum += list.get(i).val;
            map.put(list.get(i).val, sum);
        }

        updateTree(root, map);
        
        return root;
    }

    public void toList(TreeNode root, ArrayList<TreeNode> list) {
        if(root == null) { return; }
        toList(root.left, list);
        list.add(root);
        toList(root.right, list);
    }

    public void updateTree(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) { return; }
        root.val = map.get(root.val);
        updateTree(root.left, map);
        updateTree(root.right, map);
    }
}
