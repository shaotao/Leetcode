import java.io.*;
import java.util.*;


class ContiguousArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Contiguous Array ===");
	Solution solution = new Solution();

        int[] nums = {0, 1, 0};
        
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("max length = "+solution.findMaxLength(nums));
    }
}


class Solution
{
    public int findMaxLength(int[] nums) {
        int[] ones = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ones[i] = sum;
        }

        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int minus = (i-1 < 0)?0:ones[i-1];
                int len = j-i+1;
                if( len == 2*(ones[j] - minus) ) {
                    max = (max <len)?len:max;
                }
            }
        }
        return max;
    }
}
