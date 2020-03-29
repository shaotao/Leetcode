import java.io.*;
import java.util.*;

class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class PalindromeLinkedList
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();

        int[] nums = {-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557};

        int size = nums.length;
        ListNode[] nodes = new ListNode[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new ListNode(nums[i]);
        }
        
        for(int i = 0; i < size; i++) {
            nodes[i].next = (i<(size-1))?nodes[i+1]:null;
        }

        ListNode head = nodes[0];
        printList(head);
        System.out.println("isPalindrome: "+solution.isPalindrome(head));
    }

    public static void printList(ListNode head) {

        System.out.print("list: ");
        ListNode n = head;
        while(n != null) {
            System.out.print(n.val+", ");
            n = n.next;
        }
        System.out.println();
    }
}

class Solution
{
    public boolean isPalindrome(ListNode head) {
        if(head == null) { return true; }

        int size = 0;
        ListNode n = head;
        while(n != null) {
            size++;
            n = n.next;
        }

        int[] nums = new int[size];
        n = head;
        for(int i = 0; i < size; i++) {
            nums[i] = n.val;
            n = n.next;
        }

        for(int i = 0; i < size/2; i++) {
            if(nums[i] != nums[size-i-1]) {
                return false;
            }
        }

        return true;
    }
}
