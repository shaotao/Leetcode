import java.io.*;
import java.util.*;


class FindAllNumbersDisappearedInAnArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Find All Numbers in an Array ===");
	Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("nums = "+Arrays.toString(nums)+", missing = "+solution.findDisappearedNumbers(nums));
    }
}


class Solution
{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            trace(nums, i);
        }
        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] == 0) {
                list.add(idx+1);
            }
        }
        return list;
    }

    public void trace(int[] nums, int idx) {
        int next = nums[idx]-1;
        if(nums[idx] <= 0) {
            nums[idx]--;
        } else {
            nums[idx] = 0;
            trace(nums, next);
        }
    }
}
