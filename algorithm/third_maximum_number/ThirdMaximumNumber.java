import java.io.*;
import java.util.*;


class ThirdMaximumNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Third Maximum Number ===");
        Solution solution = new Solution();
        int[][] inputs = {{3,2,1},
                          {1,2},
                          {2,2,3,1}};
        for(int[] input: inputs) {
            System.out.println("input = "+Arrays.toString(input)+", 3rd max = "+solution.thirdMax(input));
        }
    }
}


class Solution
{
    public int thirdMax(int[] nums)
    {
        int[] ret = new int[3];

        if(nums.length == 0) { return 0; }
        int min = nums[0];
        // find min of nums
        for(int num: nums) { min = (min <= num)?min:num; }

        for(int i = 0; i < 3; i++) { ret[i] = min; }
 
        for(int num: nums) {
            for(int i = 0; i < 3; i++) {
                if(num == ret[i]) { break; }
                else if(num > ret[i]) {
                    for(int j = 2; j > i; j--) { ret[j] = ret[j-1]; }
                    ret[i] = num;
                    break;
                }
            }
        }
        
        return ((ret[0] != ret[1]) && (ret[1] != ret[2]))?ret[2]:ret[0];
    }
}
