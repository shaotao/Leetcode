import java.io.*;
import java.util.*;


class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}


class AddTwoNumbers
{
    public static void main(String[] args)
    {
        System.out.println("=== AddTwoNumbers ===");
        Solution solution = new Solution();

	int[] num1 = {8,6,4,7,6,1,7,5,4};
        ListNode l1 = solution.create_node(num1);

	int[] num2 = {9,8,2,0,4,8,5,3,9};
        ListNode l2 = solution.create_node(num2);


        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println();
        System.out.print("l1 = ");
        solution.print_node(l1);

        System.out.println();
        System.out.print("l2 = ");
        solution.print_node(l2);

        System.out.println();
        System.out.print("result = ");
        solution.print_node(result);
    }
}


class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head_node = null;
        ListNode result_node = null;

        ListNode n1 = l1;
        ListNode n2 = l2;

        int d1 = 0;
        int d2 = 0;
        int carry = 0;

        while(n1 != null || n2 != null)
        {
            if(n1 != null)
            {
                d1 = n1.val;
            }
            else
            {
                d1 = 0;
            }

            if(n2 != null)
            {
                d2 = n2.val;
            }
            else
            {
                d2 = 0;
            }

            int sum = d1 + d2;
            sum += carry;

            carry = sum/10;
            int new_d = sum%10;

            if(result_node == null)
            {
                result_node = new ListNode(new_d);
                head_node = result_node;
            }
            else
            {
                result_node.next = new ListNode(new_d);
                result_node = result_node.next;
            }

            // move n1 n2,
            if(n1 != null)
            {
                n1 = n1.next;
            }

            if(n2 != null)
            {
                n2 = n2.next;
            }
        }

        if(carry != 0)
        {
            result_node.next = new ListNode(carry);
        }


        return head_node;
    }

    public void print_node(ListNode node)
    {
        while(node != null)
        {
            System.out.print(node.val);
            if(node.next != null)
            {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }

    public ListNode create_node(int[] num)
    {
	ListNode head_node = null;
	ListNode node = null;

	for(int i = 0; i < num.length; i++)
	{
	    if(node == null)
	    {
		node = new ListNode(num[i]);
		head_node = node;
	    }
	    else
	    {
		node.next = new ListNode(num[i]);
		node = node.next;
	    }
	}

	return head_node;
    }
}



