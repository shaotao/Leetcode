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


class MergeTwoSortedLists
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();
	
	ListNode l1 = new ListNode(1);
	ListNode n3 = new ListNode(3);
	ListNode n5 = new ListNode(5);

	ListNode l2 = new ListNode(2);
	ListNode n4 = new ListNode(4);
	ListNode n6 = new ListNode(6);
	
	l1.next = n3;
	n3.next = n5;
	
	l2.next = n4;
	n4.next = n6;
	
	ListNode result = solution.mergeTwoLists(l1, l2);
	
	System.out.print("sorted list: ");
	ListNode node = result;
	while(node != null)
	{
	    System.out.print(node.val+" ");
	    node = node.next;
	}
	System.out.println();
    }
}


class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
	ListNode result = null;
	ListNode tail = null;

	if(l1 == null)
	{
	    return l2;
	}
	else if(l2 == null)
	{
	    return l1;
	}
	else
	{
	    if(l1.val <= l2.val)
	    {
		result = l1;
		tail = l1;
		l1 = l1.next;
	    }
	    else
	    {
		result = l2;
		tail = l2;
		l2 = l2.next;
	    }
	    
	    while(l1 != null || l2 != null)
	    {
		if(l1 == null)
		{
		    tail.next = l2;
		    break;
		}
		else if(l2 == null)
		{
		    tail.next = l1;
		    break;
		}
		else
		{
		    if(l1.val <= l2.val)
		    {
			tail.next = l1;
			tail = tail.next;
			l1 = l1.next;
		    }
		    else
		    {
			tail.next = l2;
			tail = tail.next;
			l2 = l2.next;
		    }
		}
	    }
	}

	return result;
    }
}
