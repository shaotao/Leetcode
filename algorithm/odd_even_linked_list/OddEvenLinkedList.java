import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x) {
	val = x;
	next = null;
    }
}

class OddEvenLinkedList
{
    public static void main(String[] args)
    {
	System.out.println("=== Odd Even Linked List ===");
	Solution solution = new Solution();
	int n = 5;
	ListNode head = build_list(n);

	print_list(head);

	System.out.println("after re-ordering:");
	head = solution.oddEvenList(head);

	print_list(head);
    }

    public static void print_list(ListNode head) {
	ListNode n = head;

	System.out.println("list: ");
	while(n != null) {
	    System.out.print(n.val+"->");
	    n = n.next;
	}
	System.out.println("NULL");
    }

    public static ListNode build_list(int n) {
	if(n <= 0) { return null; }

	ListNode[] nodes = new ListNode[n];
	for(int i = 1; i <= n; i++) {
	    nodes[i-1] = new ListNode(i);
	}

	for(int i = 0; i < n-1; i++) {
	    nodes[i].next = nodes[i+1];
	}

	return nodes[0];
    }
}


class Solution
{
    public ListNode oddEvenList(ListNode head) {

	if(head == null) { return null; }
	
	ListNode odd = null;
	ListNode even = null;

	ListNode cur = head;
	while(cur != null) {
	    ListNode mark_next = cur.next;
	    
	    if(odd == null) { odd = cur; }
	    else if(even == null) { even = cur; }

	    if(cur.next != null) {
		cur.next = cur.next.next;
	    }
	    
	    cur = mark_next;
	}

	// find the last odd, and link to head of even
	ListNode last_odd = odd;
	while(last_odd != null && last_odd.next != null) {
	    last_odd = last_odd.next;
	}

	last_odd.next = even;
	
	return odd;
    }
}
