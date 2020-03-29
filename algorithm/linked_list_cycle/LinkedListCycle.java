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
    public static void main(String[] args) throws Exception
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

        ListNode head = readFile("input.txt");
	has_cycle = solution.hasCycle(head);	
	System.out.println("has_cycle = "+has_cycle);
    }

    public static ListNode readFile(String filename) throws Exception {
        Scanner scan = new Scanner(new File(filename)).useDelimiter(",");
        ListNode head = null;
        ListNode prev = null;
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        while(scan.hasNextInt()) {
            int i = scan.nextInt();
            ListNode n = map.get(i);
            if(n == null) {
                n = new ListNode(i);
                map.put(i, n);
            }

            if(prev == null) { head = n; }
            else { prev.next = n; }
            prev = n;
        }

        return head;
    }
}


class Solution
{
    public Solution()
    {
    }
    
    public boolean hasCycle1(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        
        if(head == null) { return false; }

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle2(ListNode head)
    {
	ListNode p1 = head;
	ListNode p2 = head;
        
	while(p1 != null && p2 != null)
	{
            p1 = p1.next;
            if(p2.next == null) { return false; }
            else { p2 = p2.next.next; }

            if(p1 == p2) { return true; }
	}	
	
	return false;
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
