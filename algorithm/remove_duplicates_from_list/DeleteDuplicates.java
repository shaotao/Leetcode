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


class DeleteDuplicates
{
    public static void main(String[] args)
    {
	System.out.println("=== welcome to DeleteDuplicates ===");
	
	Solution solution = new Solution();

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(2);
	ListNode n4 = new ListNode(3);
	ListNode n5 = new ListNode(3);
	ListNode n6 = new ListNode(4);

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;
	n5.next = n6;
	
	print_list(n1);
	System.out.println("after removing duplicates:");
	ListNode head = solution.deleteDuplicates(n1);
	
	print_list(head);
    }

    public static void print_list(ListNode head)
    {
	ListNode n = head;
	
	System.out.println(">>> print_list");
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
    public ListNode deleteDuplicates(ListNode head)
    {
	ListNode node = head;
	while(node != null && node.next != null)
	{
	    if(node.val == node.next.val)
	    {
		node.next = node.next.next;
	    }
	    else
	    {
		node = node.next;
	    }
	}
	
	return head;
    }
}
