import java.io.*;
import java.util.*;


class ShortestUnsortedContinuousSubarray
{
    public static void main(String[] args)
    {
	System.out.println("=== Shortest Unsorted Continuous Subarray ===");
	Solution solution = new Solution();

        int[] nums= {2,6,4,8,10,9,15};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("unsorted subarray length = "+solution.findUnsortedSubarray(nums));
    }
}


class Solution
{
    public int findUnsortedSubarray(int[] nums) {
        int[] original = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);

        int left = -1;
        int right = -1;
        for(int i = 0; i < nums.length; i++) {
            if(left==-1 && original[i] != nums[i]) {
                left = i;
            }

            if(right == -1 && original[nums.length-1-i] != nums[nums.length-1-i]) {
                right = nums.length-1-i;
            }

            if(left >= 0 && right >= 0) {
                break;
            }
        }

        //System.out.println("left = "+left+", right = "+right);
        
        if(left >= 0 && right >= 0) {
            return right - left+1;
        }

        return 0;
    }
}
