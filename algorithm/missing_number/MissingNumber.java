import java.io.*;
import java.util.*;


class MissingNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Missing Number ===");
        Solution solution = new Solution();
        //int[] nums = {0, 1, 3};
        int[] nums = {1, 0};
        System.out.println("missing number = "+solution.missingNumber(nums));
    }
}

class Solution
{
    public int missingNumber(int[] nums)
    {
        if(nums == null || nums.length == 0) { return -1; }
        
        int min = nums[0];
        int max = nums[0];

        for(int num: nums) {
            min = (min>num)?num:min;
            max = (max<num)?num:max;
        }

        if(min > 0) { return 0; }
        else if(nums.length == (max - min + 1)) { return max+1; }

        // ok, the missing number x is min < x < max
        int size = max - min + 1;
        int[] slots = new int[size];
        for(int i = 0; i < size; i++) {
            slots[i] = 0;
        }
        
        for(int num: nums) {
            slots[num] = 1;
        }

        for(int i = 0; i < size; i++) {
            if(slots[i] == 0) { return i; }
        }

        return -1;
    }
}
