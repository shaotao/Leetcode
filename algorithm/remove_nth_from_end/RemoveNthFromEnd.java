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


class RemoveNthFromEnd
{
    public static void main(String[] args)
    {
	System.out.println("=== welcome to RemoveNthFromEnd ===");

	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;

	//int n = 2;
	//int n = 1;
	int n = 5;

	Solution solution = new Solution();

	ListNode head = solution.removeNthFromEnd(n1, n);

	print_list(head);
    }

    public static void print_list(ListNode head)
    {
	ListNode n = head;
	
	System.out.println(">>> print list >>>");
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
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
	// assume the n will not exceed the list, don't check the boundary
	ArrayList<ListNode> list = new ArrayList<ListNode>();

	ListNode node = head;
	while(node != null)
	{
	    list.add(node);
	    node = node.next;
	}

	int idx = list.size() - n;

	if(idx == 0)
	{
	    return head.next;
	}

	// ok, it is not the, remove the intermediate node
	list.get(idx-1).next = list.get(idx).next;

	return head;
    }
}

