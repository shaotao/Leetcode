import java.io.*;
import java.util.*;


class IncreasingTripletSubsequence
{
    public static void main(String[] args)
    {
	System.out.println("=== Increasing Triplet Subsequence ===");
	Solution solution = new Solution();

        int[][] array = {{1,2,3,4,5},
                         {5,4,3,2,1},
                         {1,2,3,1,2,1}};

        for(int[] nums: array) {
            System.out.println("array = "+Arrays.toString(nums));
            System.out.println("ret = "+solution.increasingTriplet(nums));
        }
    }
}


class Solution
{
    public boolean increasingTriplet(int[] nums)
    {
        if(nums == null || nums.length < 3) {
            return false;
        }

        Integer a = null;
        Integer b = null;
        
        for(int num:nums) {
            if (a == null || num <= a) { a = num; }
            else if (b == null || num <= b) { b = num; }
            else { return true; }
        }
        
        return false;
    }
}
