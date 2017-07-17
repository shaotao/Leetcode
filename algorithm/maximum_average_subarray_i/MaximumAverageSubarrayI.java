import java.io.*;
import java.util.*;


class MaximumAverageSubarrayI
{
    public static void main(String[] args)
    {
	System.out.println("=== Maxmum Average Subarray I ===");
	Solution solution = new Solution();

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("k = "+k);
        System.out.println("max average is: "+solution.findMaxAverage(nums, k));
    }
}


class Solution
{
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;
        
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        for(int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            max = (sum>max)?sum:max;
        }
        
        return max/k;
    }
}
