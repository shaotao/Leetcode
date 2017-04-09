import java.io.*;
import java.util.*;


class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}


class ReverseLinkedList
{
    public static void main(String[] args)
    {
        System.out.println("=== Reverse Linked List ===");
        Solution solution = new Solution();
        int[] nums = { 1,2,3,4,5,6,7 };
        if(nums.length == 0)
        {
            System.out.println("empty list!");
            return;
        }
        ListNode[] nodes = new ListNode[nums.length];
        for(int i = nums.length-1; i >= 0; i--)
        {
            nodes[i] = new ListNode(nums[i]);
            if(i < nums.length-1)
            {
                nodes[i].next = nodes[i+1];
            }
        }

        printNodes(nodes[0]);
        ListNode head = solution.reverseList(nodes[0]);
        printNodes(head);
    }

    public static void printNodes(ListNode head)
    {
        ListNode node = head;
        System.out.print("list: ");
        while(node != null)
        {
            System.out.print(node.val+", ");
            node = node.next;
        }
        System.out.println();
    }
}

class Solution
{
    // the recursive method
    public ListNode reverseList(ListNode head)
    {
        ListNode node = head;

        if(node == null) { return null; }
        else if(node.next == null) { return node; }
        else {
            ListNode ret = reverseList(node.next);
            node.next.next = node;
            node.next = null;
            return ret;
        }
    }
    
    // the iteraive method using a stack
    public ListNode reverseList2(ListNode head)
    {
        ListNode ret = null;
        ListNode node = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while(node != null)
        {
            stack.push(node);
            node = node.next;
        }

        if(stack.size() > 0) { ret = stack.pop(); }

        ListNode cur = ret;
        while(stack.size() > 0)
        {
            ListNode next = stack.pop();
            cur.next = next;
            cur = next;
            cur.next = null;
        }

        return ret;
    }
}
