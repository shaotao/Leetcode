import java.io.*;
import java.util.*;


class MaxConsecutiveOnes
{
    public static void main(String[] args)
    {
	System.out.println("=== Max Consecutive Ones ===");
	Solution solution = new Solution();
        int[] nums = {1,1,0,1,1,1};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("max consecutive ones = "+solution.findMaxConsecutiveOnes(nums));
    }
}


class Solution
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int num : nums) {
            if(num==1) {
                count++;
                max = (count>max)?count:max;
            } else {
                count = 0;
            }
        }

        return max;
    }
}
