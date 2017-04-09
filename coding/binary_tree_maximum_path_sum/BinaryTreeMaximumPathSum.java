import java.io.*;
import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class BinaryTreeMaximumPathSum
{
    public static void main(String[] args)
    {
        System.out.println("=== Binary Tree Maximum Path Sum ===");
        Solution solution = new Solution();
        TreeNode root = create_tree();
        int result = solution.maxPathSum(root);
        System.out.println("max path sum = "+result);
    }

    public static TreeNode create_tree()
    {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;

        return n1;
    }
}

class Pair
{
    TreeNode parent;
    TreeNode child;
    public Pair(TreeNode parent, TreeNode child)
    {
        this.parent = parent;
        this.child = child;
    }
}

class Solution
{
    public static void print_matrix(Integer[][] matrix) {
        if(matrix == null) { return; }
        int num_rows = matrix.length;
        if(num_rows == 0) { return; }

        int num_cols = matrix[0].length;
        
        for(int i = 0; i < num_rows; i++) {
            for(int j = 0; j < num_cols; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }        
    }

    public int maxPathSum(TreeNode root)
    {
        int result = 0;

        // map the val to the index
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

        if(root == null) { return 0; }

        LinkedList<Pair> input = new LinkedList<Pair>();
        LinkedList<Pair> output = new LinkedList<Pair>();
        input.add(new Pair(null, root));
        int num = 0;
        while(input.size() > 0) {
            Pair n = input.poll();
            output.add(n);
            map.put(n.child, num);
            if(n.child.left != null) { input.add(new Pair(n.child, n.child.left)); }
            if(n.child.right != null) { input.add(new Pair(n.child, n.child.right)); }
            num++;
        }

        // create the distance matrix
        Integer[][] matrix = new Integer[num][num];

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                matrix[i][j] = null;
            }
        }

        for(Pair p: output) {
            TreeNode parent = p.parent;
            TreeNode child = p.child;
            
            int parent_idx = (parent==null)?-1:map.get(parent);
            int child_idx = map.get(child);
            
            matrix[child_idx][child_idx] = child.val;
            if(parent != null) {
                for(int i = 0; i < num; i++) {
                    if(i == child_idx) { continue; }
                    if(matrix[parent_idx][i] != null) {
                        matrix[child_idx][i] = child.val + matrix[parent_idx][i];
                        matrix[i][child_idx] = child.val + matrix[parent_idx][i];
                    }
                }
            }
        }
        
        //print_matrix(matrix);

        result = matrix[0][0];
        for(int i = 0; i < num; i++)
        {
            for(int j = i; j < num; j++) {
                if(result < matrix[i][j]) { result = matrix[i][j]; }
            }
        }
        
        return result;
    }
}
