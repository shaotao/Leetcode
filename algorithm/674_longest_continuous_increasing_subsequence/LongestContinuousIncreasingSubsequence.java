import java.io.*;
import java.util.*;


class LongestContinuousIncreasingSubsequence
{
    public static void main(String[] args)
    {
        System.out.println("=== Longest Continuous Increasing Subsequence ===");
        Solution solution = new Solution();
        int[][] input = {{1,3,5,4,7}, {2,2,2,2,2}};
        for (int[] nums : input) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("LCIS = "+solution.findLengthOfLCIS(nums));
        }
    }
}


class Solution
{
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int count = 0;
        int prev = -1;
        for (int i : nums) {
            if (max == 0 || i > prev) {
                count++;
                max = (count>max)?count:max;
            } else {
                count = 1;
            }
            prev = i;
        }

        return max;
    }
}
