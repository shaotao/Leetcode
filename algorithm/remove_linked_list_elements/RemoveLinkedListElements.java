import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}

class RemoveLinkedListElements
{
    public static void main(String[] args) {
        System.out.println("=== Remove Linked List Elements ===");
        Solution solution = new Solution();
        int[] array = {1,2,6,3,4,5,6};
        ListNode[] nodes = new ListNode[array.length];
        for (int i = array.length-1; i >= 0; i--) {
            nodes[i] = new ListNode(array[i]);
            if(i < array.length-1) { nodes[i].next = nodes[i+1]; }
        }
        int val = 6;

        print_nodes(nodes[0]);
        ListNode n = solution.removeElements(nodes[0], 6);
        print_nodes(n);
    }
    public static void print_nodes(ListNode root) {
        System.out.print("nodes: ");
        if(root == null) { return; }
        ListNode n = root;
        while(n != null) {
            System.out.print(n.val+", ");
            n = n.next;
        }
        System.out.println();
    }
}

class Solution
{
    public ListNode removeElements(ListNode head, int val) {
        // find the new root
        ListNode root = null;
        ListNode cur = head;
        while(cur != null && cur.val == val) {
            cur = cur.next;
        }

        ListNode next = null;
        if(cur != null) { root = cur; }
        while(cur != null) {
            next = cur.next;
            while(next != null && next.val == val) {
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }

        return root;
    }
}
