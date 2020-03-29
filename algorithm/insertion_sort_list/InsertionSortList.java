import java.io.*;
import java.util.*;


class InsertionSortList
{
    public static void main(String[] args)
    {
	System.out.println("=== Insertion Sort List ===");
	ListNode n1 = new ListNode(4);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(5);
	ListNode n4 = new ListNode(3);
	ListNode n5 = new ListNode(1);
	
	n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
	
	Solution solution = new Solution();

	print_list(n1);

	ListNode result = solution.insertionSortList(n1);
	
	print_list(result);
    }

    public static void print_list(ListNode node)
    {
	System.out.print("list: ");
	while(node != null)
	{
	    System.out.print(node.val+" ");
	    node = node.next;
	}
	System.out.println();
    }
}

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int x)
    {
	this.val = x;
	this.next = null;
    }
}

class Solution
{
    public Solution() {}

    public ListNode insertionSortList(ListNode head)
    {
	ListNode result = null;

	while(head != null)
	{
	    ListNode node = head;
	    head = head.next;
	    
	    if(result == null)
	    {
		result = node;
		result.next = null;
	    }
	    else if(result.val >= node.val)
	    {
		node.next = result;
		result = node;
	    }
	    else
	    {
		ListNode curr = result;
		while(curr.next != null && curr.next.val < node.val)
		{
		    curr = curr.next;
		}
		
		node.next = curr.next;
		curr.next = node;
	    }
	}

	return result;
    }
}
