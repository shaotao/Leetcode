import java.io.*;
import java.util.*;


class Verify
{
    public static void main(String[] args)
    {
	System.out.println("=== Verify Preorder Serialization of a Binary Tree ===");
	Solution solution = new Solution();

        String[] inputs = {"9,3,4,#,#,1,#,#,2,#,6,#,#",
                           "1,#",
                           "9,#,#,1"};
        for (String input: inputs) {
            System.out.println(input+": "+solution.isValidSerialization(input));
        }
    }
}


class Node
{
    int val;
    int count;

    public Node(int val) {
        this.val = val;
        this.count = 0;
    }
}

class Solution
{
    public boolean isValidSerialization(String preorder)
    {
        boolean ret = false;

        Stack<Node> stack = new Stack<Node>();
        
        StringTokenizer stok = new StringTokenizer(preorder, ",");

        int idx = 0;
        Node prev = null;
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();

            if(idx == 0) {
                if(!token.equals("#")) { 

                    int val = Integer.parseInt(token);
                    Node n = new Node(val);
                    stack.push(n);
                    prev = n;
                }
            } else {
                if(prev == null) { return false; }
                
                if(token.equals("#")) {
                    prev.count++;
                    if(prev.count >= 3) { return false; }

                    while(prev != null && prev.count == 2) {
                        stack.pop();
                        prev = (stack.size()>0)?stack.peek():null;
                    }
                    
                } else {
                    int val = Integer.parseInt(token);
                    Node n = new Node(val);
                    stack.push(n);
                    prev.count++;
                    if(prev.count >= 3) { return false; }
                    prev = n;
                }
            }
            
            idx++;
        }
        
        return (stack.size() == 0);
    }
}
