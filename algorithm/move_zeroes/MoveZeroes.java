import java.io.*;
import java.util.*;


class MoveZeroes
{
    public static void main(String[] args)
    {
        System.out.println("=== Move Zeroes ===");
        Solution solution = new Solution();
        int[][] array_nums = {{0,1,0,3,12}};
        for(int[] nums: array_nums) {
            solution.moveZeroes(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}

class Solution
{
    public void moveZeroes(int[] nums)
    {
        int size = nums.length;
        int num_zeroes = 0;
        for(int i = 0; i < size; i++) {
            int num = nums[i];

            if(num == 0) {
                num_zeroes++;
            } else if(num_zeroes > 0) {
                nums[i-num_zeroes] = num;
                nums[i] = 0;
            }
        }
    }
}
