import java.io.*;
import java.util.*;


class ContainsDuplicate
{
    public static void main(String[] args)
    {
        System.out.println("=== Contains Duplicate ===");
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        print_array(nums);
        boolean ret = solution.containsDuplicate(nums);
        System.out.println("contains duplicate: "+ret);
    }

    public static void print_array(int[] nums)
    {
        System.out.print("nums: ");
        for(int num: nums)
        {
            System.out.print(num+",");
        }
        System.out.println();
    }
}

class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums) {
            if(map.containsKey(num)) { return true;}
            else {
                map.put(num, num);
            }
        }

        return false;
    }
}
