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


class RotateList
{
    public static void main(String[] args)
    {
	System.out.println("=== Rotate List ===");

	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = new ListNode(5);

	int n = 8;

	System.out.println("input = "+print_list(head));
	System.out.println("n = "+n);

	Solution solution = new Solution();

	ListNode result = solution.rotateRight(head, n);

	System.out.println("result = "+print_list(result));
    }

    public static String print_list(ListNode head)
    {
	ListNode node = head;
	StringBuffer buf = new StringBuffer("");

	while(node != null)
	{
	    buf.append(node.val+" ");
	    node = node.next;
	}
	
	return buf.toString();
    }
}


class Solution
{
    public Solution()
    {
    }

    public ListNode rotateRight(ListNode head, int n)
    {
	// connect the tail to head
	if(head == null || n <= 0)
	{
	    return head;
	}

	ListNode node = head;
	ListNode tail = head;
	
	int len = 0;
	while(node != null)
	{
	    tail = node;
	    len += 1;

	    node = node.next;	    
	}

	tail.next = head;

	// break the parent link to the new head
	int shift = n%len;
	
	int num_steps_forward = len - shift-1;

	node = head;
	for(int i = 0; i < num_steps_forward; i++)
	{
	    node = node.next;
	}
	
	ListNode result = node.next;
	node.next = null;

	return result;
    }
}
