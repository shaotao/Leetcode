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

class PartitionList
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        
        ListNode n1 = new ListNode(1);
        ListNode n4 = new ListNode(4);
        n1.next = n4;
        ListNode n3 = new ListNode(3);
        n4.next = n3;
        ListNode n2 = new ListNode(2);
        n3.next = n2;
        ListNode n5 = new ListNode(5);
        n2.next = n5;
        ListNode n2b = new ListNode(2);
        n5.next = n2b;

        int x = 3;

        ListNode result = solution.partition(n1, x);
        
        PartitionList.print_list(result);
    }

    public static void print_list(ListNode root)
    {
        ListNode n = root;
        System.out.print("list: ");
        while(n != null)
        {
            System.out.print(n.val+", ");
            n = n.next;
        }
        System.out.println();
    }
}

class Solution
{
    public ListNode partition(ListNode head, int x)
    {
        boolean updated = false;
        
        do
        {
            ListNode prev = null;
            ListNode curr = null;
            ListNode next = null;

            curr = head;
            next = (curr != null)?curr.next:null;
        
            updated = false;

            while(curr != null && next != null)
            {
                if(curr.val >= x && next.val < x)
                {
                    // swap curr and next
                    if(prev == null)
                    {
                        // head swap
                        curr.next = next.next;
                        next.next = curr;
                        head = next;
                    }
                    else
                    {
                        // non-head swap
                        prev.next = next;
                        curr.next = next.next;
                        next.next = curr;
                    }

                    updated = true;
                }

                prev = curr;
                curr = curr.next;
                next = (curr != null)? curr.next: null;
                
            }

        } while (updated == true);

        
        return head;
    }
}
