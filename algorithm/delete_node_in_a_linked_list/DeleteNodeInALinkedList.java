import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class DeleteNodeInALinkedList
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        
        printList(n1);
        solution.deleteNode(n3);
        printList(n1);
    }

    public static void printList(ListNode head) {
        ListNode n = head;

        System.out.print("List: ");
        while(n != null) {
            System.out.print(n.val);
            if(n.next != null) { System.out.print(","); }
            n = n.next;
        }
        System.out.println();
    }
}

class Solution
{
    public void deleteNode(ListNode node) {
        ListNode n = node;

        ListNode prev = null;
        while(n != null && n.next != null) {
            n.val = n.next.val;
            prev = n;
            n = n.next;
        }

        if(prev != null) { prev.next = null; }
    }
}
