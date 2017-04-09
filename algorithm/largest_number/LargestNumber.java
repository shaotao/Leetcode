import java.io.*;
import java.util.*;


class LargestNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Largest Number ===");
        Solution solution = new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        //int[] nums = {0, 0};
        
        String result = solution.largestNumber(nums);

        System.out.print("nums: "+Arrays.toString(nums));

        System.out.println();
        System.out.println("largest number = "+result);
    }
}

class Solution
{
    public String largestNumber(int[] nums)
    {
        String result = "";

        int size = nums.length;
        for(int i = 0; i < size; i++)
        {
            for(int j = i+1; j < size; j++)
            {
                if(!greater(nums, i, j))
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for(int i:nums)
        {
            result += i;
        }

        boolean allzero = true;
        for(int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if(ch != '0') {
                allzero = false;
                break;
            }
        }
        
        return (allzero)?"0":result;
    }
    
    // if num[i] > num[j], return true
    // else return false;
    private boolean greater(int[] nums, int i, int j)
    {
        if(nums == null || nums.length <= 0 ||
           i < 0 || i >= nums.length ||
           j < 0 || j >= nums.length ||
           i >= j) {
            System.out.println("Solution.compare() error: invalid input i = "+i+", j = "+j);
            return false;
        }
        
        String a = ""+nums[i];
        String b = ""+nums[j];

        long num1 = Long.parseLong(a+b);
        long num2 = Long.parseLong(b+a);

        return (num1 > num2);
    }
}
