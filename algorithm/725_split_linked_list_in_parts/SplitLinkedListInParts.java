import java.io.*;
import java.util.*;


class SplitLinkedListInParts
{
    public static void main(String[] args)
    {
        System.out.println("=== Split Linked List in Parts ===");
        Solution solution = new Solution();

        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(3);
        n11.next = n12; n12.next = n13;
        int k = 5;
        System.out.println("list = "+solution.toString(n11));
        System.out.println("k = "+k);
        System.out.println("parts = "+solution.deepToString(solution.splitListToParts(n11, k)));

        ListNode n21 =new ListNode(1);
        ListNode n22 =new ListNode(2);
        ListNode n23 =new ListNode(3);
        ListNode n24 =new ListNode(4);
        ListNode n25 =new ListNode(5);
        ListNode n26 =new ListNode(6);
        ListNode n27 =new ListNode(7);
        ListNode n28 =new ListNode(8);
        ListNode n29 =new ListNode(9);
        ListNode n210 =new ListNode(10);
        n21.next = n22; n22.next = n23; n23.next = n24; n24.next = n25;
        n25.next = n26; n26.next = n27; n27.next = n28; n28.next = n29;
        n29.next = n210;
        k = 3;
        System.out.println("list = "+solution.toString(n21));
        System.out.println("k = "+k);
        System.out.println("parts = "+solution.deepToString(solution.splitListToParts(n21, k)));
    }
}

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution
{
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ret = new ListNode[k];
        if (root == null) { return ret; }
        // first get the number of nodes
        int numNodes = 0;
        ListNode n = root;
        while(n != null) {
            numNodes++;
            n = n.next;
        }

        n = root;
        int total = 0;
        for (int i = 0; i < k; i++) {
            int numListsLeft = k - i;
            int target = (numNodes-total)/numListsLeft + (((numNodes-total)%numListsLeft==0)?0:1);
            //System.out.println("numListsLeft = "+numListsLeft+", target = "+target);

            int count = 0;
            while(n != null) {
                total++;
                count++;
                if (count == 1) {
                    ret[i] = n;
                }

                if (count < target) {
                    n = n.next;
                } else {
                    ListNode tmp = n;
                    n = n.next;
                    tmp.next = null;
                    count = 0;
                    break;
                }
            }
        }
        
        return ret;
    }

    public String toString(ListNode n) {
        if (n == null) { return null; }
        else {
            return Integer.toString(n.val)+(n.next==null?"":"->"+toString(n.next));
        }
    }

    public String deepToString(ListNode[] nodes) {
        if (nodes == null) { return null; }
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        for (int i = 0; i < nodes.length; i++) {
            buf.append(toString(nodes[i]));
            if (i < nodes.length-1) {
                buf.append(",");
            }
        }
        buf.append("]");
        return buf.toString();
    }
}
