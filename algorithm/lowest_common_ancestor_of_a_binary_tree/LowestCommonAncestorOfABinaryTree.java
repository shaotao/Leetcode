import java.io.*;
import java.util.*;


class LowestCommonAncestorOfABinaryTree
{
    public static void main(String[] args)
    {
        System.out.println("=== Lowest Common Ancestor Of A Binary Search Tree ===");
        Solution solution = new Solution();

        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n3.left = n5;
        n3.right = n1;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n2.left = n7;
        n2.right = n4;

        System.out.println("LCA of 5 and 1 is: "+solution.lowestCommonAncestor(n3, n5, n1).val);
        System.out.println("LCA of 5 and 4 is: "+solution.lowestCommonAncestor(n3, n5, n4).val);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        ArrayList<TreeNode> list_p = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list_q = new ArrayList<TreeNode>();
        boolean find_p = find(root, p, list_p);
        boolean find_q = find(root, q, list_q);

        System.out.println("list_p: ");
        for(TreeNode n: list_p) {
            System.out.print(n.val+",");
        }
        System.out.println();

        System.out.println("list_q: ");
        for(TreeNode n: list_q) {
            System.out.print(n.val+",");
        }
        System.out.println();
        
        if(!find_p || !find_q) {
            return null;
        }

        int size = (list_p.size() < list_q.size())?list_p.size():list_q.size();

        TreeNode ret = null;
        for(int i = 0; i < size; i++) {
            if(list_p.get(i) == list_q.get(i)) {
                ret = list_p.get(i);
            }
        }

        return ret;
    }

    // this one will cause stack overflow, need an iterative version
    //
    public boolean find2(TreeNode root, TreeNode target, ArrayList<TreeNode> list) {
        if(root == null || target == null || list == null) {
            return false;
        }

        list.add(root);
        if(target.val == root.val) {
            return true;
        } else {
            boolean find_left = find(root.left, target, list);
            if(find_left == true) { return true; }
            
            boolean find_right = find(root.right, target, list);
            if(find_right == true) { return true; }

            if(list.size() > 0) {
                list.remove(list.size()-1);
            }
            return false;
        }
    }

    // iterative depth-first-search
    public boolean find(TreeNode root, TreeNode target, ArrayList<TreeNode> list) {
        if(root == null || target == null || list == null) {
            System.out.println("find() error: some input is null!");
            return false;
        }
        
        list.add(root);

        // we have 2 directions: down 0, up 1
        int dir = 0;
        TreeNode prev = null;
        while(list.size() > 0) {
            TreeNode n = list.get(list.size()-1);

            if(n == target) { return true; }

            if(dir == 0) {
                // from previous node, go down to this node
                if(n.left != null) {
                    // left
                    list.add(n.left);
                    dir = 0;
                } else if(n.right != null) {
                    // no left, right
                    list.add(n.right);
                    dir = 0;
                } else {
                    // no left or no left
                    list.remove(list.size()-1);
                    dir = 1;
                }
            } else {
                // from previous node, go up to this node
                // if comes from left child, try right,
                // if comes from right child, go up
                if(prev == n.left && n.right != null) {
                    // down right
                    list.add(n.right);
                    dir = 0;
                } else {
                    list.remove(list.size()-1);
                    dir = 1;
                }
            }

            prev = n;
        }
        
        return false;
    }
}
