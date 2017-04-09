import java.io.*;
import java.util.*;

class RandomListNode
{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}


class CopyListWithRandomPointer
{
    public static void main(String[] args)
    {
        System.out.println("=== Copy List with Random Pointer ===");
        Solution solution = new Solution();

        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);

        n1.next = n2; n1.random = n3;
        n2.next = n3; n2.random = n1;
        n3.next = null; n3.random = n2;

        RandomListNode result = solution.copyRandomList(n1);

        while(result != null)
        {
            System.out.print("("+result.label+", "+result.random.label+")");
            if(result.next != null) { System.out.print(" -> "); }
            result = result.next;
        }
        System.out.println();
    }
}


class Solution
{
    public RandomListNode copyRandomList(RandomListNode head)
    {
        RandomListNode result = null;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

        // before creating the new node, check if it is already in map
        RandomListNode cur = head;
        RandomListNode cur_copy;
        while(cur != null)
        {
            RandomListNode next = null;
            RandomListNode random = null;

            if(map.containsKey(cur.label))
            {
                cur_copy = map.get(cur.label);
            }
            else
            {
                cur_copy = new RandomListNode(cur.label);
                if(result == null) { result = cur_copy; }
                map.put(cur.label, cur_copy);
            }

            // check for cur.next
            if(cur.next != null)
            {
                if(map.containsKey(cur.next.label))
                {
                    next = map.get(cur.next.label);
                }
                else
                {
                    next = new RandomListNode(cur.next.label);
                    map.put(cur.next.label, next);
                }
            }
            cur_copy.next = next;

            // check for cur.random
            if(cur.random != null)
            {
                if(map.containsKey(cur.random.label))
                {
                    random = map.get(cur.random.label);
                }
                else
                {
                    random = new RandomListNode(cur.random.label);
                    map.put(cur.random.label, random);
                }
            }
            cur_copy.random = random;

            cur = cur.next;
        }

        return result;
    }
}
