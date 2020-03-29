import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }

    public String toString()
    {
        return this.val+"";
    }
}

public class LinkedListRandomNode
{
    public static void main(String[] args)
    {
	System.out.println("=== Linked List Random Node ===");

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

	Solution solution = new Solution(head);

        for(int i = 0; i < 10; i++) {
            System.out.println(solution.getRandom());
        }
    }
}


class Solution
{
    ListNode head = null;
    Random rand = null;
    int size = 0;
    
    public Solution(ListNode head) {
        rand = new Random();
        ListNode n = head;
        while(n != null) {
            size++;
            n = n.next;
        }
        this.head = head;
    }

    public int getRandom() {
        if(size == 0) {
            return -1;
        }

        int idx = rand.nextInt(size);
        ListNode n = head;
        for(int i = 0; i < idx; i++) {
            n = n.next;
        }

        return n.val;
    }
}
