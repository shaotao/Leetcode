import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class BSTIterator
{
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode tmp = root;
        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        if(stack.empty()) { return -1; }

        TreeNode node = stack.pop();
        TreeNode tmp = node.right;
        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        return node.val;
    }
}

public class BinarySearchTreeIterator
{
    public static void main(String[] args)
    {
        System.out.println("=== Binary Search Tree Iterator ===");
        TreeNode root = create_tree();
        System.out.println("root = "+root.val);
        BSTIterator iter = new BSTIterator(root);
        int seq = 0;
        while(iter.hasNext()) {
            seq++;
            System.out.println(seq+") tree node = "+iter.next());
        }
    }

    public static TreeNode create_tree() {
        int num = 15;
        TreeNode[] nodes = new TreeNode[num];
        for(int i = 0; i < num; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes[7].left = nodes[3];
        nodes[7].right = nodes[11];

        nodes[3].left = nodes[1];
        nodes[3].right = nodes[5];

        nodes[11].left = nodes[9];
        nodes[11].right = nodes[13];

        nodes[1].left = nodes[0];
        nodes[1].right = nodes[2];

        nodes[5].left = nodes[4];
        nodes[5].right = nodes[6];

        nodes[9].left = nodes[8];
        nodes[9].right = nodes[10];

        nodes[13].left = nodes[12];;
        nodes[13].right = nodes[14];

        return nodes[7];
    }
}

