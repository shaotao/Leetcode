import java.io.*;
import java.util.*;


class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x)
    {
        val = x;
        next = null;
    }
}

class Solution
{
    public ListNode sortList(ListNode head)
    {
        ListNode result = null;

        // nodes with val < head
        ListNode left_head = null;
        ListNode left_tail = null;

        // nodes with val = head
        ListNode middle_head = null;
        ListNode middle_tail = null;
        
        // nodes with val > head
        ListNode right_head = null;
        ListNode right_tail = null;

        ListNode cur = null;

        // ensure we need to sort the list
        if(head == null || head.next == null) { return head; }
        
        // separate the list by comparing with head
        cur = head;
        while(cur != null) {
            if(cur.val < head.val) {
                if(left_head == null) { left_head = cur; }
                else { left_tail.next = cur; }
                left_tail = cur;
            } else if (cur.val == head.val) {
                if(middle_head == null) { middle_head = cur; }
                else { middle_tail.next = cur; }
                middle_tail = cur;
            } else {
                if(right_head == null) { right_head = cur; }
                else { right_tail.next = cur; }
                right_tail = cur;
            }
            
            cur = cur.next;
        }

        // sort left and right separately and link left.tail to right.head
        if(left_tail != null) { left_tail.next = null; }
        if(middle_tail != null) { middle_tail.next = null; }
        if(right_tail != null) { right_tail.next = null; }

        /*
        System.out.print("left = ");
        SortList.print_list(left_head);
        System.out.print("middle = ");
        SortList.print_list(middle_head);
        System.out.print("right = ");
        SortList.print_list(right_head);
        System.out.println("=======");
        //System.exit(0);
        */

        left_head = sortList(left_head);
        right_head = sortList(right_head);

        if(left_head == null) {
            result = middle_head;
            middle_tail.next = right_head;
        } else {
            result = left_head;
            cur = left_head;
            while(cur.next != null) {
                cur = cur.next;
            }
            
            cur.next = middle_head;
            middle_tail.next = right_head;
        }
        
        return result;
    }
}

public class SortList
{
    //private static final int seed = 1236;
    //private static final Random rand = new Random(seed);
    private static final Random rand = new Random();

    public static void main(String[] args)
    {
        int len = 10;

        System.out.println("=== Sort List ===");
        Solution solution = new Solution();
        
        ListNode head = create_list(len);
        
        System.out.println("before sort: ");
        print_list(head);

        head = solution.sortList(head);
        
        System.out.println("after sort: ");
        print_list(head);
    }

    public static void print_list(ListNode head)
    {
        ListNode cur = head;

        System.out.print("list: ");
        while(cur != null) {
            System.out.print(cur.val);
            if(cur.next != null) {
                System.out.print(", ");                
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode create_list(int len)
    {
        ListNode head = null;
        ListNode cur = null;

        for(int i = 0; i < len; i++)
        {
            ListNode n = new ListNode(rand.nextInt(len));
            if(cur == null) {
                cur = n; 
                head = n;
            } else {
                cur.next = n;
                cur = cur.next;
            }
        }

        return head;
    }
}
