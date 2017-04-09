import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class PathSum2
{
    public static void main(String[] args)
    {
        TreeNode n5 = new TreeNode(5);

        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);

        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4b = new TreeNode(4);

        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4; n5.right = n8;
        n4.left = n11; n8.left = n13; n8.right = n4b;
        n11.left = n7; n11.right = n2; n4b.right = n1;
        
        Solution solution = new Solution();
        int sum = 22;
        ArrayList<ArrayList<Integer>> result = solution.pathSum(n5, sum);
        System.out.println("sum = "+sum);
        print_list(result);
    }
    
    public static void print_list(ArrayList<ArrayList<Integer>> result)
    {
        for(int i = 0; i < result.size(); i++)
        {
            ArrayList<Integer> list = result.get(i);
            System.out.print(i+"): ");
            for(int j = 0; j < list.size(); j++)
            {
                System.out.print(list.get(j)+", ");
            }
            System.out.println();
        }
    }
}

class Solution
{
    public Solution()
    {
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(root, sum, list, result);
        return result;
            
    }

    public void dfs(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result)
    {
        if(root == null) { return; }
        else if(root.left == null && root.right == null) 
        {
            if(root.val == sum) { list.add(root.val); result.add(new ArrayList<Integer>(list)); list.remove(list.size()-1); return;}
            else { return; }
        }
        
        list.add(root.val);
        if(root.left != null)
        {
            dfs(root.left, sum-root.val, list, result);
        }
        
        if(root.right != null)
        {
            dfs(root.right, sum-root.val, list, result);
        }
        
        list.remove(list.size()-1);
        
        return;
    }
}
