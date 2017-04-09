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

    public String toString()
    {
	return val+"";
    }
}


class DeleteDuplicates2
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
	//n3.next = n4;
	//n4.next = n5;
	//n5.next = n6;
	
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
	ListNode result = null;
	ListNode tail = null;

	ListNode parent = null;

	ListNode node = head;

	while(node != null)
	{

	    if( (parent == null || parent.val != node.val) &&
		(node.next == null || node.next.val != node.val) )
	    {
		// this is a good node
		if(tail == null)
		{
		    tail = node;
		    result = node;
		}
		else
		{
		    tail.next = node;
		    tail = node;
		}
	    }
	    
	    parent = node;
	    node = node.next;
	}

	if(tail != null)
	{
	    tail.next = null;
	}
	return result;
    }
}
