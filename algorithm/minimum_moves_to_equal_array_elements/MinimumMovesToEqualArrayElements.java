import java.io.*;
import java.util.*;


class MinimumMovesToEqualArrayElements
{
    public static void main(String[] args)
    {
	System.out.println("=== Minimum Moves to Equal Array Elements ===");
	Solution solution = new Solution();
        //int[] nums = {1,2,3};
        //int[] nums = {29,73,21,19,84,37,98,24,15,70};
        int[] nums = {32,-40,-24,68,39,-88,-74,86,-6,39};

        System.out.println("nums = "+Arrays.toString(nums));
        int ret = solution.minMoves(nums);
        System.out.println("sorted = "+Arrays.toString(nums));
        System.out.println("min moves = "+ret);
    }
}


class Solution
{
    public int minMoves(int[] nums) {
        int ret = 0;

        quicksort(nums, 0, nums.length-1);

        //System.out.println("sorted: "+Arrays.toString(nums));
        
        for(int i = 1; i < nums.length; i++) {
            ret += nums[i] - nums[0];
        }

        return ret;
    }

    private void swap(int[] nums, int i, int j) {
        if(nums == null ||
           i >= nums.length || i < 0 ||
           j >= nums.length || j < 0) {
            return;
        } else {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    public void quicksort(int[] nums, int left, int right) {
        if (nums == null || left >= right) { return; }

        int pivot_idx = (left+right)/2;
        int pivot = nums[pivot_idx];
        
        int i = left;
        int j = right;
        
        while(i <= j) {
            
            while(nums[i] < pivot && i < right) {
                i++;
            }
            
            while(nums[j] > pivot && j > left) {
                j--;
            }
            
            if(i <= j) {
                swap(nums, i, j);
                if(i < right) {
                    i++;
                }

                if(j > left) {
                    j--;
                }
            }
        }
        
        quicksort(nums, left, j);
        quicksort(nums, i, right);
    }
}
