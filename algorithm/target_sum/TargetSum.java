import java.io.*;
import java.util.*;


class TargetSum
{
    public static void main(String[] args)
    {
	System.out.println("=== Target Sum ===");
	Solution solution = new Solution();

        int[] nums = {1,1,1,1,1};
        int S = 3;
        int ret = solution.findTargetSumWays(nums, S);
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("S = "+S);
        System.out.println("ret = "+ret);
    }
}


class Solution
{
    public int findTargetSumWays(int[] nums, int S) {
        int[] count = new int[1];
        int sum = 0;

        sumTree(nums, 0, sum, S, count);
        
        return count[0];
    }

    public void sumTree(int[] nums, int i, int sum, int S, int[] count) {
        if(i >= nums.length) {
            return;
        } else if (i < nums.length-1) {
            sumTree(nums, i+1, sum+nums[i], S, count);
            sumTree(nums, i+1, sum-nums[i], S, count);
        } else if (i == nums.length-1) {
            if(sum + nums[i] == S) { count[0] += 1; }
            if(sum - nums[i] == S) { count[0] += 1; }
        }
    }
}
