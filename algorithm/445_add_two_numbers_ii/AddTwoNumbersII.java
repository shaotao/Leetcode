import java.io.*;
import java.util.*;


class AddTwoNumbersII
{
    public static void main(String[] args)
    {
        System.out.println("=== Add Two Numbers II ===");
        Solution solution = new Solution();
        ListNode n11 = new ListNode(7);
        ListNode n12 = new ListNode(2);
        ListNode n13 = new ListNode(4);
        ListNode n14 = new ListNode(3);
        n11.next = n12; n12.next = n13; n13.next = n14;

        ListNode n21 = new ListNode(5);
        ListNode n22 = new ListNode(6);
        ListNode n23 = new ListNode(4);
        n21.next = n22; n22.next = n23;
        ListNode l1 = n11; ListNode l2 = n21;
        ListNode sum = solution.addTwoNumbers(l1, l2);

        System.out.println("l1 = "+solution.toString(l1));
        System.out.println("l2 = "+solution.toString(l2));
        System.out.println("sum = "+solution.toString(sum));
    }
}


class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
}

class Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = toString(l1);
        String s2 = toString(l2);

        // add s1 and s2 up as String
        String sum = addAsString(s1, s2);
        return toListNode(sum);
    }

    private String addAsString(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return s2;
        } else if (s2 == null || s2.length() == 0) {
            return s1;
        }
        int maxLen = (s1.length() >= s2.length())?s1.length():s2.length();

        String ret = "";
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int idx1 = (s1.length()-1-i);
            int idx2 = (s2.length()-1-i);
            int val1 = (idx1 >= 0)?Integer.parseInt(s1.substring(idx1,idx1+1)):0;
            int val2 = (idx2 >= 0)?Integer.parseInt(s2.substring(idx2,idx2+1)):0;
            int val = val1 + val2 + carry;
            ret = val%10+ret;
            carry = (val > 9)?1:0;
        }

        if(carry > 0) {
            ret = carry + ret;
        }

        return ret;
    }

    private ListNode toListNode(String s) {
        if (s == null || s.length() == 0) {
            return null;
        } else if(s.length()==1) {
            return new ListNode(Integer.parseInt(s));
        } else {
            ListNode head = new ListNode(Integer.parseInt(s.substring(0,1)));
            head.next = toListNode(s.substring(1)); 
            return head;
        }
    }

    public String toString(ListNode n) {
        if (n == null) {
            return "";
        } else if (n.next == null) {
            return Integer.toString(n.val);
        } else {
            return Integer.toString(n.val)+toString(n.next);
        }
    }
}
