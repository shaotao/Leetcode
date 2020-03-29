import java.io.*;
import java.util.*;


class KillProcess
{
    public static void main(String[] args)
    {
	System.out.println("=== Kill Process ===");
	Solution solution = new Solution();

        List<Integer> pid = Arrays.asList(1,3,10,5);
        List<Integer> ppid = Arrays.asList(3,0,5,3);
        int kill = 5;

        System.out.println("pid = "+pid);
        System.out.println("ppid = "+ppid);
        System.out.println("kill = "+kill);
        System.out.println("kill process = "+solution.killProcess(pid, ppid, kill));
    }
}

class TreeNode
{
    int val;
    List<TreeNode> children;
    public TreeNode(int x) {
        this.val = x;
        children = new ArrayList<TreeNode>();
    }
}

class Solution
{
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();

        if(!pid.contains(kill)) { return ret; }
        
        // build tree
        for(Integer i: pid) {
            TreeNode n = new TreeNode(i);
            map.put(i, n);
        }

        // populate children
        for(int i = 0; i < pid.size(); i++) {
            TreeNode n = map.get(pid.get(i));
            TreeNode parent = map.get(ppid.get(i));
            if(parent == null) { continue; }

            parent.children.add(n);
        }

        ret.add(kill);
        for(int i = 0; i < ret.size(); i++) {
            TreeNode n = map.get(ret.get(i));
            for(TreeNode child : n.children) {
                ret.add(child.val);
            }
        }
        
        return ret;
    }
}
