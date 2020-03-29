import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTreePaths
{
    public static void main(String[] args)
    {
        System.out.println("=== Binary Tree Paths ===");
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.right = n5;

        List<String> list = solution.binaryTreePaths(n1);
        for(String path: list) {
            System.out.println(path);
        }
    }
}

class Solution
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        ArrayList<String> list = new ArrayList<String>();

        TreeNode prev = null;
        TreeNode curr = root;

        ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
        tmp.add(root);
        while(curr != null) {

            // check if there is any left or right child
            if(curr.left == null && curr.right == null) {
                list.add(parse(tmp));
                prev = curr;
                // move up
                tmp.remove(tmp.size()-1);
                curr = (tmp.size()>0)?tmp.get(tmp.size()-1):null;
            } else if(curr.left != null) {
                if(prev != curr.left &&
                   (curr.right == null ||
                    (curr.right != null && prev != curr.right))) {
                    // go left
                    prev = curr;
                    curr = curr.left;
                    tmp.add(curr);
                } else if(curr.right != null && prev != curr.right) {
                    // go right
                    prev = curr;
                    curr = curr.right;
                    tmp.add(curr);
                } else {
                    // go up
                    prev = curr;
                    tmp.remove(tmp.size()-1);
                    curr = (tmp.size()>0)?tmp.get(tmp.size()-1):null;
                }
            } else if(curr.right != null) {
                if(prev != curr.right) {
                    // go right
                    prev = curr;
                    curr = curr.right;
                    tmp.add(curr);
                } else {
                    // go up
                    prev = curr;
                    tmp.remove(tmp.size()-1);
                    curr = (tmp.size()>0)?tmp.get(tmp.size()-1):null;
                }
            }
        }
        
        return list;
    }

    public String parse(ArrayList<TreeNode> tmp) {

        if(tmp == null || tmp.size() == 0) { return "";}

        StringBuffer buf = new StringBuffer("");
        for(int i = 0; i < tmp.size(); i++) {
            buf.append(tmp.get(i).val);
            if(i < tmp.size()-1) {
                buf.append("->");
            }
        }

        return buf.toString();
    }
}
