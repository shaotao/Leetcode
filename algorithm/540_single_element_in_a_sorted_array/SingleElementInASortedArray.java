import java.io.*;
import java.util.*;


class SingleElementInASortedArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Single Element in a Sorted Array ===");
        Solution solution = new Solution();
        int[][] input = {{1,1,2,3,3,4,4,8,8}, {3,3,7,7,10,11,11}};
        for (int[] nums : input) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("single element = "+solution.singleNonDuplicate(nums));
        }
    }
}


class Solution
{
    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int left, int right) {
        //System.out.println("left = "+left+", right = "+right);
        
        if (nums == null || left < 0 || right >= nums.length || right < left) {
            return -1;
        }

        if(right - left < 2) {
            return nums[left];
        }
        
        int middle = (right+left)/2;
        if (nums[middle] != nums[middle-1] && nums[middle] != nums[middle+1]) {
            return nums[middle];
        }

        if(middle%2 == 0) {
            if (nums[middle] == nums[middle+1]) {
                return find(nums, middle+2, right);
            } else {
                return find(nums, left, middle-2);
            }
        } else {
            if (nums[middle] == nums[middle-1]) {
                return find(nums, middle+1, right);
            } else {
                return find(nums, left, middle-1);
            }
        }
    }
}
