import java.io.*;
import java.util.*;


class HouseRobber2
{
    public static void main(String[] args)
    {
        System.out.println("=== House Robber 2 ===");
        int[] nums = {2,3,4,5,3,1,1,3,4,5,6,2,1};
        Solution solution = new Solution();

        int ret = solution.rob(nums);
        print_array(nums);
        System.out.println("ret = "+ret);
    }

    public static void print_array(int[] nums)
    {
        System.out.print("nums: ");
        for(int num: nums) {
            System.out.print(num+",");
        }
        System.out.println();
    }
}

class Solution
{
    public int rob(int[] nums)
    {
        if(nums.length == 1) {
            return nums[0];
        }

        // scan the array twice
        // 0 ~ n-2
        int sum1 = rob_sum(nums, 0, nums.length-2);
        // 1 ~ n-1
        int sum2 = rob_sum(nums, 1, nums.length-1);

        return (sum1>sum2)?sum1:sum2;
    }

    public int rob_sum(int[] nums, int start_idx, int end_idx) {
        if(nums == null || start_idx < 0 || end_idx >= nums.length ||
           end_idx < start_idx) {
            return 0;
        }
        int size = end_idx - start_idx + 1;
        int[] array = new int[size];

        for(int i = start_idx; i <= end_idx; i++) {
            if(i == start_idx) {
                array[i-start_idx] = nums[i];
            } else if (i == start_idx+1) {
                array[i-start_idx] = (nums[i] > nums[i-1])?nums[i]:nums[i-1];
            } else if (i == start_idx+2) {
                array[i-start_idx] = (nums[i] + nums[i-2] > nums[i-1])?(nums[i]+nums[i-2]):nums[i-1];
            } else {
                array[i-start_idx] = ((nums[i] + array[i-2-start_idx]) > (nums[i-1] + array[i-3-start_idx]))?
                    (nums[i]+array[i-2-start_idx]):(nums[i-1]+array[i-3-start_idx]);
            }
        }

        return array[size-1];
    }
}
