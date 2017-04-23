import java.io.*;
import java.util.*;


class ArrayPartitionI
{
    public static void main(String[] args)
    {
	System.out.println("=== Array Partition I ===");
	Solution solution = new Solution();

        int[] nums = {1,4,3,2};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("array pair sum = "+solution.arrayPairSum(nums));
    }
}


class Solution
{
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }

        return sum;
    }
}
