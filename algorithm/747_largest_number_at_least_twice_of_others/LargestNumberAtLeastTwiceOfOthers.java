import java.io.*;
import java.util.*;


class LargestNumberAtLeastTwiceOfOthers
{
    public static void main(String[] args)
    {
        System.out.println("=== Largest Number At Least Twice of Others ===");
        Solution solution = new Solution();
        int[][] array_nums = {{3,6,1,0}, {1,2,3,4}, {1}, {1,0}};
        for (int[] nums : array_nums) {
            System.out.println("nums = "+Arrays.toString(nums));
            System.out.println("dominant index = "+solution.dominantIndex(nums));
        }
    }
}


class Solution
{
    public int dominantIndex(int[] nums) {
        int[] seen = new int[2];
        if (nums.length == 1) { return 0; }

        int min = nums[0];
        for(int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        
        seen[0] = min;
        seen[1] = min;

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > seen[0]) {
                seen[1] = seen[0];
                seen[0] = num;
                idx = i;
            } else if (num > seen[1]) {
                seen[1] = num;
            }
        }

        //System.out.println("seen = "+Arrays.toString(seen));

        return (seen[0] >= 2*seen[1])?idx:-1;
    }
}
