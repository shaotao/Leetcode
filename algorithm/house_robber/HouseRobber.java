import java.io.*;
import java.util.*;


class HouseRobber
{
    public static void main(String[] args)
    {
        System.out.println("=== House Robber ===");
        Solution solution = new Solution();

        //int[] num = {1,6,5,3,7,8,9,5,4,3,5,7,3,5,4,4,4,5,6,7,8,9,5,4,3,2,5,6,8,9,5,4,4,3,5,6,7,8,0,2,1,3,4,5,6};
        int[] num = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        int ret = solution.rob(num);
        System.out.println("max amount robbed = "+ret);
    }
}

class Solution
{
    // greedy algo, pick the houses with most money, non-continuous.
    public int rob(int[] nums)
    {
        if(nums == null || nums.length < 1) { return 0; }

        int[] array = new int[nums.length];

        // populate the array to get the maximum amount to rob at each
        // index
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0) { array[i] = nums[i]; }
            else if(i == 1) {
                array[i] = (nums[i] > nums[i-1])?nums[i]:nums[i-1];
            } else {
                array[i] = (nums[i] + array[i-2] > array[i-1])? (nums[i]+array[i-2]):array[i-1];
            }
        }
        
        return array[nums.length-1];
    }
}
