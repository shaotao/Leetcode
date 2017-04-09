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


class LinkedListCycle2
{
    public static void main(String[] args)
    {
	System.out.println("=== Linked List Cycle II ===");
	
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
	n4.next = n5;		
	n5.next = n6;

	ListNode cycle_node = solution.detectCycle(n1);	
	if(cycle_node != null) 
	{
	    System.out.println("cycle node = "+cycle_node.val);
	}
	else
	{
	    System.out.println("no cycle!");
	}

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n2;
	
	cycle_node = solution.detectCycle(n1);	
	if(cycle_node != null) 
	{
	    System.out.println("cycle node = "+cycle_node.val);
	}
	else
	{
	    System.out.println("no cycle!");
	}	
    }
}


class Solution
{
    public Solution()
    {
    }
    
    public ListNode detectCycle(ListNode head)
    {
	ListNode node = head;
	ArrayList<ListNode> list = new ArrayList<ListNode>();
	
	while(node != null)
	{
	    for(int i = 0; i < list.size(); i++)
	    {
		if(node == list.get(i)) { return node; }		
	    }

	    list.add(node);
	    
	    node = node.next;
	}	
	
	return null;
    }
}
