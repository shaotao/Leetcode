import java.io.*;
import java.util.*;


class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SerializeAndDeserializeBinaryTree
{
    public static void main(String[] args) {
        System.out.println("=== Serialize and Deserialize Binary Tree ===");
        Codec codec = new Codec();
        
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left= n4;
        n3.right = n5;

        String str = codec.serialize(n1);
        System.out.println("str = "+str);
        TreeNode root = codec.deserialize(str);

        System.out.println("=== Print Tree ===");
        printTree(n1);
        System.out.println("=== Print Tree ===");
        printTree(root);
    }

    public static void printTree(TreeNode root)
    {
        if(root == null) { return; }
        System.out.println("node = "+root.val+", left = "+((root.left != null)?root.left.val:null)+", right = "+((root.right != null)?root.right.val:null));
        printTree(root.left);
        printTree(root.right);
    }
}

class Codec
{
    public String serialize(TreeNode root) {
        StringBuffer buf = new StringBuffer();

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode node = root;
        if(root != null) { list.add(root); }

        int idx = 0;
        while(idx < list.size()) {
            TreeNode n = list.get(idx);

            if(n != null) {
                list.add(n.left);
                list.add(n.right);
            }
            
            idx++;
        }

        // trim the trailing nulls
        for(int i = list.size()-1; i>= 0; i--) {
            if(list.get(i) == null) {
                list.remove(i);
            } else {
                break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            TreeNode n = list.get(i);
            String str = null;
            if(n == null) {
                str = "null";
            } else {
                str = new String(""+n.val);
            }
            buf.append(str);
            if(i < list.size()-1) { buf.append(","); }
        }
        
        return buf.toString();
    }

    public TreeNode deserialize(String data) {
        TreeNode root = null;

        StringTokenizer stok = new StringTokenizer(data, ",");

        // get the list of tree nodes
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while(stok.hasMoreTokens()) {
            String item = stok.nextToken();
            if(item.equals("null")) {
                list.add(null);
            } else{
                list.add(new TreeNode(Integer.parseInt(item)));
            }
        }

        // build the tree
        int parent_idx = 0;
        int child_idx = 1;
        while(parent_idx < list.size() && child_idx < list.size()) {

            // get parent
            TreeNode parent = list.get(parent_idx);
            if(parent == null) { parent_idx++; continue; }
            
            // get left
            parent.left = list.get(child_idx);
            
            // increase child_idx
            child_idx++;
            
            // get right
            if(child_idx >= list.size()) { continue; }
            parent.right = list.get(child_idx);

            // increase child_idx
            child_idx++;
            
            // increase root_idx
            parent_idx++;
        }
        
        return (list.size() > 0)?list.get(0):null;
    }
}
