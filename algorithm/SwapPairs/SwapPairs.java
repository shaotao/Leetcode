import java.io.*;
import java.util.*;


class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
	this.val = val;
	this.next = null;
    }
}


class SwapPairs
{
    public static void main(String[] args)
    {
	Solution solution = new Solution();
	
	ListNode node1 = new ListNode(1);
	ListNode node2 = new ListNode(2);
	ListNode node3 = new ListNode(3);
	ListNode node4 = new ListNode(4);
	
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	
	print_list(node1);

	ListNode head = solution.swapPairs(node1);

	print_list(head);
    }
    
    public static void print_list(ListNode head)
    {
	System.out.println("=== list ===");
	
	if(head == null)
	{	     
	    return;
	}

	System.out.print(head.val);
	ListNode next_node = head.next;
	while(next_node != null)
	{
	    System.out.print("->"+next_node.val);
	    next_node = next_node.next;
	}
	System.out.println();
    }
}  



class Solution
{
    public Solution()
    {
    }

    public ListNode swapPairs(ListNode head)
    {
	if(head == null || head.next == null)
	{
	    return head;
	}

	ListNode result = head.next;

	ListNode curr = new ListNode(0);
	curr.next = head;
	
	while(curr != null && curr.next != null && curr.next.next != null)
	{
	    ListNode p1 = curr.next;
	    ListNode p2 = curr.next.next;
	    ListNode p2_next = p2.next;

	    curr.next = p2;
	    p2.next = p1;
	    p1.next = p2_next;

	    curr = p1;
	}

	return result;
    }
}

