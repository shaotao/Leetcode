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


class MergeKLists
{
    public static void main(String[] args)
    {
	System.out.println("=== Merge K Sorted Lists ===");
	
	ListNode n1 = new ListNode(1);
	
	ArrayList<ListNode> lists = new ArrayList<ListNode>();
	lists.add(null);
	lists.add(n1);

	Solution solution = new Solution();
	
	ListNode result = solution.mergeKLists(lists);
	
	print_list(result);
    }

    public static void print_list(ListNode head)
    {
	ListNode node = head;
	
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
    public ListNode mergeKLists(ArrayList<ListNode> lists)
    {
	ListNode result = null;
	ListNode curr = null;
	while(lists.size() > 0)
	{
	    ListNode target = null;
	    int idx = -1;
	    for(int i = lists.size()-1; i >= 0; i--)
	    {
		ListNode node = lists.get(i);

		if(node == null) 
		{ 
		    continue; 
		}

		if(target == null || node.val < target.val)
		{
		    target = node;
		    idx = i;
		}
	    }

	    if(target != null)
	    {
		if(curr == null) 
		{
		    result = target;
		    curr = target;
		}
		else
		{
		    curr.next = target;
		    curr = curr.next;
		}
		
		lists.remove(idx);
		if(target.next != null)
		{
		    lists.add(idx, target.next);
		}
	    }

	    for(int i = lists.size() -1; i >= 0; i--)
	    {
		if(lists.get(i) == null) { lists.remove(i); }
	    }
	}

	return result;
    }
}
