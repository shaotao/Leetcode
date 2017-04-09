import java.io.*;
import java.util.*;


class ContainsDuplicate2
{
    public static void main(String[] args)
    {
        System.out.println("=== Contains Duplicate II ===");
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 2, 1};
        int k = 2;
        boolean ret = solution.containsNearbyDuplicate(nums, k);
        System.out.print("nums: ");
        for(int num: nums) {
            System.out.print(num+", ");
        }
        System.out.println();
        System.out.println("k = "+2);
        System.out.println("contains nearby duplicate: "+ret);
    }
}


class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                if(i - map.get(num) <= k) {
                    return true;
                } else {
                    map.put(num, i);
                }
            } else {
                map.put(num, i);
            }
        }
        
        return false;
    }
}
