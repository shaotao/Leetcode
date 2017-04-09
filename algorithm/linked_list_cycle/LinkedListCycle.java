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


class LinkedListCycle
{
    public static void main(String[] args)
    {
	System.out.println("=== Linked List Cycle ===");
	
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

	boolean has_cycle = solution.hasCycle(n1);	
	System.out.println("has_cycle =  "+has_cycle);

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n2;
	
	has_cycle = solution.hasCycle(n1);	
	System.out.println("has_cycle = "+has_cycle);

	has_cycle = solution.hasCycle(null);	
	System.out.println("has_cycle = "+has_cycle);
    }
}


class Solution
{
    public Solution()
    {
    }
    
    public boolean hasCycle(ListNode head)
    {
	ListNode node = head;
	HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
	
	while(node != null)
	{
	    if(map.containsKey(node)) { return true; }

	    map.put(node, 1);
	    
	    node = node.next;
	}	
	
	return false;
    }
}
