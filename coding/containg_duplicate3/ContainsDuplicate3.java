import java.io.*;
import java.util.*;


class ContainsDuplicate3
{
    public static void main(String[] args) {
        System.out.println("=== Contains Duplicate 3 ===");
        Solution solution = new Solution();
        //int[] nums = {1,2,3,4,5,6,7,8};
        int[] nums = {1,5,10};
        int k = 2;
        int t = 3;

        boolean ret = solution.containsNearbyAlmostDuplicate(nums, k, t);
        print_array(nums);
        System.out.println("k = "+k+", t = "+t);
        System.out.println("contains duplicate3: "+ret);
    }

    public static void print_array(int[] nums) {
        System.out.print("nums: ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i < nums.length-1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}


class Solution
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j <= i+k && j < nums.length; j++) {
                int diff = (nums[i] > nums[j])?(nums[i] - nums[j]):(nums[j] - nums[i]);
                if(diff <= t) { return true;}
            }
        }

        return false;
    }
}
