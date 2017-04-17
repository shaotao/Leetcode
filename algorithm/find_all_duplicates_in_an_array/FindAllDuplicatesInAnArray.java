import java.io.*;
import java.util.*;


class FindAllDuplicatesInAnArray
{
    public static void main(String[] args)
    {
	System.out.println("=== Find All Duplicates In an Array ===");
	Solution solution = new Solution();

        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("duplicates = "+solution.findDuplicates(nums));
    }
}


class Solution
{
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0) { continue; }
            trace(nums, i, list);
        }

        return list;
    }

    private void trace(int[] nums, int i, List<Integer> list) {
        int idx = nums[i]-1;
        nums[i] = 0;
        while(idx >= 0) {
            int tmp = nums[idx]-1;
            if(nums[idx] <= 0) {
                nums[idx] -= 1;
                if(nums[idx] == -2) {
                    list.add(idx+1);
                }
            } else {
                nums[idx] = -1;
            }
            idx = tmp;
        }
    }
}
