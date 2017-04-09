import java.io.*;
import java.util.*;


class LongestIncreasingSubsequence
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Increasing Subsequence ===");
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ret = solution.lengthOfLIS(nums);
        System.out.print("nums = ");
        for(int i : nums) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("length of LIS = "+ret);
    }
}

class Solution
{
    public int lengthOfLIS(int[] nums)
    {
        int maxlen = 0;

        int[] vals = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
            int max_prev = 0;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    max_prev = (max_prev > vals[j])?max_prev:vals[j];
                }
            }

            vals[i] = max_prev+1;
        }

        // scan vals for the maxlen
        for (int val : vals) {
            maxlen = (maxlen > val)?maxlen:val;
        }

        return maxlen;
    }
}
