import java.io.*;
import java.util.*;


class MajorityElement
{
    public static void main(String[] args)
    {
        System.out.println("=== Majority Element ===");
        Solution solution = new Solution();
        int[] num = {2,4,3,2,2,1,2};
        
        int result = solution.majorityElement(num);
        System.out.print("array: ");
        for(int i: num) {
            System.out.print(" "+i);
        }
        System.out.println();
        System.out.println("majority element: "+result);
    }
}

class Solution
{
    public int majorityElement(int[] num)
    {
        int target_count = num.length/2 + 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();        

        for(int i: num) {
            if(map.get(i) == null) {
                map.put(i, 1);
            } else {
                int new_count = map.get(i) + 1;
                if(new_count >= target_count) { return i; }
                map.put(i, new_count);
            }
        }
        
        return num[0];
    }
}
