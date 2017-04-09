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


class ReverseKGroup
{
    public static void main(String[] args)
    {
	System.out.println("=== Reverse List in k-Group ===");

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
	//n5.next = n6;
	
	int k = 2;

	System.out.println("k = "+k);
	System.out.println("input list:");
	print_list(n1);

	ListNode head = solution.reverseKGroup(n1, k);

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

    public ListNode reverseKGroup(ListNode head, int k)
    {
	// get the length of thelist
	int len = 0;
	ListNode node = head;
	while(node != null)
	{
	    len += 1;

	    node = node.next;
	}

	if(k <= 1 || len < k)
	{
	    return head;
	}

	int t = len/k;


	ListNode result = get_node(head, k-1);


	ListNode next_block_head = head;
	for(int idx = 0; idx <= (t-1)*k; idx += k)
	{
	    ListNode block_head = next_block_head;

	    // get the next block head before we break the link
	    next_block_head = get_node(block_head, k);

	    ListNode curr = block_head;
	    ListNode next = curr.next;


	    for(int i = 0; i < k-1; i++)
	    {
		ListNode temp = next.next;
		next.next = curr;

		curr = next;
		next = temp;
	    }

	    // now, we set the next link of block_head, it
	    // is the tail of the block now
	    int next_idx = idx + k;

	    if(idx == (t-1)*k)
	    {
		block_head.next = next_block_head;
	    }
	    else
	    {
		block_head.next = get_node(next_block_head, k-1);
	    }
	    
	}


	return result;
    }

    public ListNode get_node(ListNode start, int num_steps)
    {
	ListNode node = start;

	int i = 0;
	while(node != null && i < num_steps)
	{
	    node = node.next;
	    i++;
	}

	return node;
    }
}
