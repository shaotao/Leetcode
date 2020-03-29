import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) { val = x; }
}

class CountCompleteTreeNodes
{
    public static void main(String[] args)
    {
        System.out.println("=== Count Complete Tree Nodes ===");
        Solution solution = new Solution();

        int size = 1532;
        TreeNode root = createTree(size);
        int ret = solution.countNodes(root);
        
        System.out.println("tree size: "+size+", ret = "+ret);
    }

    public static TreeNode createTree(int n)
    {
        if(n <= 0) { return null; }

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        for(int i = 0; i < n; i++) {
            TreeNode node = new TreeNode(i);
            list.add(node);
        }

        int parent_idx = 0;
        int child_idx = parent_idx + 1;

        while(child_idx < list.size()) {
            TreeNode parent = list.get(parent_idx);
            TreeNode child = (list.size()>1)?list.get(child_idx):null;

            if(child_idx %2 == 1) {
                parent.left = child;
            } else {
                parent.right = child;                
                parent_idx++;
            }

            child_idx++;
        }
        
        return list.get(0);
    }
}


class Solution
{
    // use binary search to find the last node
    public int countNodes(TreeNode root)
    {
        int h = -1;
        TreeNode node = root;
        while(node != null) {
            h++;
            node = node.left;
        }

        if (h < 0) { return 0; }
        else if (h == 0) { return 1; }
        
        int left = (1<<h);
        int right = (1<<(h+1))-1;

        int count = 0;

        while(left < right) {
            if(right - left == 1) {
                count = (find(root, h, right))?right:left;
                //System.out.println("count_last_row = "+count_last_row);
                break;
            } else {
                int middle = (left+right)/2;
                boolean find_middle = find(root, h, middle);
                //System.out.println("h = "+h+", find_middle = "+find_middle);
                if(find_middle) { left = middle; }
                else { right = middle; }
            }
        }

        return count;
    }

    public boolean find(TreeNode root, int h, int k)
    {
        boolean found = false;
        TreeNode node = root;

        for(int i = h-1; i >= 0; i--) {
            if(node == null) { break; }
            int mask = (1<<i);
            if((k & mask) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }

            if( i ==0 && node != null) {
                found = true;
            }
        }

        //System.out.println("find: h = "+h+", k = "+k+", found = "+found);

        return found;
    }
    
    // put all nodes into a list
    public int countNodes2(TreeNode root)
    {
        int ret = 0;

        if(root == null) { return 0; }
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        list.add(root);

        int idx = 0;
        while(idx < list.size()) {

            TreeNode node = list.get(idx);
            if(node.left != null) {
                list.add(node.left);
            }

            if(node.right != null) {
                list.add(node.right);
            }
            
            idx++;
        }
        
        return idx;
    }
}
