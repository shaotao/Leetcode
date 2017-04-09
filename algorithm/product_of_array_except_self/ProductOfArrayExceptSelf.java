import java.io.*;
import java.util.*;


class ProductOfArrayExceptSelf
{
    public static void main(String[] args)
    {
        System.out.println("=== Product of Array Except Self ==");
        int[] nums = {1,2,3,4};
        Solution solution = new Solution();
        int[] results = solution.productExceptSelf(nums);

        printArray(nums, "nums");
        printArray(results, "results");
    }

    public static void printArray(int[] nums, String s) {
        System.out.print(s+": ");
        for(int i: nums) {
            System.out.print(i+",");
        }
        System.out.println(); 
    }
}

class Solution
{
    public int[] productExceptSelf(int[] nums)
    {
        int size = nums.length;
        if(nums == null) { return null; }
        if(nums.length == 0) { return nums; }

        int[] results = new int[size];
        int[] left = new int[size];
        int[] right = new int[size];

        int product = 1;
        for(int i = 0; i < size; i++) {
            left[i] = (product *= nums[i]);
        }

        product = 1;
        for(int i = size-1; i >= 0; i--) {
            right[i] = (product *= nums[i]);
        }

        for(int i = 0; i < size; i++) {
            results[i] = ((i==0)?1:left[i-1])*((i == size-1)?1:right[i+1]);
        }

        return results;
    }
}
