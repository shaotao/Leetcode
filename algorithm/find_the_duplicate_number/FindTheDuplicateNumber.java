import java.io.*;
import java.util.*;


class FindTheDuplicateNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Find the Duplicate Number ===");
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,3};
        int ret = solution.findDuplicate(nums);

        System.out.println("nums = "+Arrays.toString(nums));
        System.out.println("duplicate = "+ret);
    }
}


class Solution
{
    public int findDuplicate(int[] nums)
    {
        int ret = -1;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    ret = nums[i];
                    break;
                }
            }
        }

        return ret;
    }
}
