import java.io.*;
import java.util.*;


class NonDecreasingArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Non-decreasing Array ===");
	Solution solution = new Solution();
        int[][] array_nums = {{4,2,3},
                              {4,2,1},
                              {2,3,3,2,4},
                              {3,4,2,3},
                              {-1, 4, 2, 3}};
        for(int[] nums : array_nums) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("possible: "+solution.checkPossibility(nums));
        }
    }
}


class Solution
{
    public boolean checkPossibility(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        boolean fixed = false;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums.length > 1 && nums[i] > nums[i+1]) {
                    nums[i] = nums[i+1];
                    fixed = true;
                }
            } else if (nums.length > 1 && i == nums.length-1) {
                if (nums[i] < nums[i-1]) {
                    if (!fixed) {
                        nums[i] = nums[i-1];
                        fixed = true;
                    } else {
                        return false;
                    }
                }
            } else if (nums.length > 2 && i > 0 && i < nums.length-1) {
                if (nums[i-1] <= nums[i+1]) {
                    if (nums[i] < nums[i-1] || nums[i] > nums[i+1]) {
                        if (!fixed) {
                            nums[i] = nums[i-1];
                            fixed = true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    if(nums[i] < nums[i-1]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
