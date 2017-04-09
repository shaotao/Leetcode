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


class ReorderList
{
    public static void main(String[] args)
    {
	System.out.println("=== Reorder List ===");
	
	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);
	ListNode n6 = new ListNode(6);
	ListNode n7 = new ListNode(7);
	
	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;
	n5.next = n6;
	n6.next = n7;
	
	print_list(n1);
	
	Solution solution = new Solution();
	
	solution.reorderList(n1);
	
	print_list(n1);
    }
    
    public static void print_list(ListNode node)
    {
	System.out.println(">> list");
	while(node != null)
	{
	    System.out.print(node.val+" ");
	    node = node.next;
	}
	System.out.println();
	System.out.println("<< list");
    }
}

class Solution
{
    public Solution()
    {
    }

    public void reorderList2(ListNode head)
    {
	// get the list length
	int n = 0;
	ListNode node = head;
	
	while(node != null) { n++; node = node.next; }
	
	for(int i = 0; i < (n-1)/2; i++)
	{
	    // 1. get the last element
	    ListNode last2 = head;
	    ListNode last = head.next;
	    
	    if(last == null) { return; }
	    
	    while(last.next != null)
	    {
		last2 = last;
		last = last.next;
	    }
	    last2.next = null;
	    
	    // 2. last should go to index (2*i + 1)
	    ListNode prev = head;
	    for(int j = 0; j < 2*i; j++)
	    {
		prev = prev.next;
	    }
	    
	    // 3. insert last between prev and prev.next
	    last.next = prev.next;
	    prev.next = last;
	}
    }

    public void reorderList(ListNode head)
    {
	ListNode node = head;

	ArrayList<ListNode> list = new ArrayList<ListNode>();

	while(node != null)
	{
	    list.add(node);
	    node = node.next;
	}
	
	int num_nodes = list.size();
	for(int i = 0; i < (num_nodes-1)/2; i++)
	{
	    list.get(i).next = list.get(num_nodes-i-1);
	    list.get(num_nodes-i-1).next = list.get(i+1);
	}

	if(num_nodes > 0) { list.get(num_nodes/2).next = null; }
    }
}
