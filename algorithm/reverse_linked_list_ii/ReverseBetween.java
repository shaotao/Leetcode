import java.io.*;
import java.util.*;


class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
	this.val = val;
    }
}


class ReverseBetween
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse Linked List II ===");

	Solution solution = new Solution();

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	//n4.next = n5;
	//n5.next = n6;
	
	int m = 1;
	int n = 4;

	System.out.println("m = "+m+", n = "+n);
	System.out.println("input list:");
	print_list(n1);

	ListNode head = solution.reverseBetween(n1, m, n);

	System.out.println("output list:");
	print_list(head);
    }

    public static void print_list(ListNode head)
    {
	ListNode n = head;
	
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
    public Solution()
    {
    }

    public ListNode reverseBetween(ListNode head, int m, int n)
    {
	// get the length of thelist
	int len = 0;
	ListNode node = head;

	ListNode block_parent = null;
	ListNode node_n = null;

	int i = 0;
	while(node != null)
	{
	    i += 1;

	    if(i < m)
	    {
		block_parent = node;
	    }
	    
	    if(i == m)
	    {
		ListNode node_m = node;
		ListNode curr = node;
		ListNode next = node.next;

		ListNode temp = null;
		for(int j = 0; j < (n-m); j++)
		{
		    temp = next.next;
		    next.next = curr;
		    
		    curr = next;
		    next = temp;
		}

		if(block_parent != null)
		{
		    block_parent.next = curr;
		}

		node_n = curr;
		node_m.next = next;

		break;
	    }

	    node = node.next;
	}
	
	if(m > 1)
	{
	    return head;
	}
	else
	{
	    return node_n;
	}

    }

}
