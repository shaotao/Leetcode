import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class Intersection
{
    public static void main(String[] args)
    {
        System.out.println("=== Intersection of Two Linked Lists ===");
        Solution solution = new Solution();
        
        ListNode a1 = new ListNode(11);
        ListNode a2 = new ListNode(12);
        
        ListNode b1 = new ListNode(21);
        ListNode b2 = new ListNode(22);
        ListNode b3 = new ListNode(23);

        ListNode c1 = new ListNode(31);
        ListNode c2 = new ListNode(32);
        ListNode c3 = new ListNode(33);
        
        a1.next = a2; a2.next = c1;
        b1.next = b2; b2.next = b3; b3.next = c1;
        c1.next = c2; c2.next = c3;
        
        ListNode result = solution.getIntersectionNode(a1, b1);

        System.out.println("list1 = ");
        print_list(a1);

        System.out.println("list2 = ");
        print_list(b1);

        System.out.println("intersection = " + ((result != null)?result.val:null));
    }

    public static void print_list(ListNode head)
    {
        ListNode n = head;

        while(n != null)
        {
            System.out.print(n.val+((n.next != null)?" -> ":" "));
            n = n.next;
        }
        System.out.println();
    }
}


class Solution
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode result = null;

        // get the list size of A
        int sizeA = 0;
        ListNode n = headA;
        while (n != null)
        {
            sizeA++;
            n = n.next;
        }

        int sizeB = 0;
        n = headB;
        while (n != null)
        {
            sizeB++;
            n = n.next;
        }
        
        int size = 0;
        if(sizeA < sizeB) {
            size = sizeA;
            for(int i = 0; i < (sizeB - sizeA); i++) {
                headB = headB.next;
            }
        } else {
            size = sizeB;
            for(int i = 0; i < (sizeA - sizeB); i++) {
                headA = headA.next;
            }
        }
        
        for(int i = 0; i < size; i++) {
            if(headA.equals(headB)) {
                result = headA;
                break;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        
        return result;
    }
}
