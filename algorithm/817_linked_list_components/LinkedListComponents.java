import java.io.*;
import java.util.*;


class LinkedListComponents
{
    public static void main(String[] args)
    {
        System.out.println("=== Linked List Components ===");
        Solution solution = new Solution();
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;
        
        int[] G = {0, 3, 1, 4};

        int ret = solution.numComponents(n0, G);
        printList(n0);
        System.out.println("G = "+Arrays.toString(G));
        System.out.println("num components = "+ret);
    }

    private static void printList(ListNode head) {
        ListNode n = head;
        System.out.print("list: ");
        while(n != null) {
            System.out.print(n.val);
            if(n.next != null) {
                System.out.print("->");
            }
            n = n.next;
        }
        System.out.println();
    }
}


class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution
{
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }

        ListNode prev = null;
        ListNode n = head;
        int count = 0;
        while (n != null) {
            if (set.contains(n.val)) {
                if (prev == null || !set.contains(prev.val)) {
                    count++;
                }
            }
            prev = n;
            n = n.next;
        }
        
        return count;
    }
}
