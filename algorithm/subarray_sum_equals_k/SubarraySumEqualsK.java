import java.io.*;
import java.util.*;


class SubarraySumEqualsK
{
    public static void main(String[] args)
    {
	System.out.println("=== Subarray Sum Equals K ===");
	Solution solution = new Solution();

        //int[] nums = {1,1,1};
        //int k = 2;

        int[] nums = {1,2,3};
        int k = 3;

        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("k = "+k);
        System.out.println("# of subarrays = "+solution.subarraySum(nums, k));
    }
}


class Solution
{
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) { return 0; }
        int size = nums.length;
        int[] initials = new int[size];

        int ret = 0;
        
        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += nums[i];
            initials[i] = sum;
        }

        for(int i = 0; i < size; i++) {
            sum = initials[i];
            for(int j = i; j < size; j++) {
                if(j>i) {
                    sum += nums[j];
                    sum -= nums[j-i-1];
                }

                if(sum == k) {
                    ret++;
                }
            }   
        }
        
        return ret;
    }
}
