import java.io.*;
import java.util.*;


public class RotateArray
{
    public static void main(String[] args)
    {
        System.out.println("=== Rotate Array ===");
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int k = -3;
        //int[] nums = {1,2,3};
        //int k = 2;

        print_array(nums);
        solution.rotate(nums, k);
        print_array(nums);
    }
    
    public static void print_array(int[] nums)
    {
        System.out.print("nums: ");
        for(int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]+((i<nums.length-1)?", ":""));
        }
        System.out.println();
    }
}

class Solution
{
    // version us O(n) space
    public void rotate(int[] nums, int k)
    {
        int[] temp = new int[nums.length];
        
        // if nums is null or empty, do nothing
        if (nums == null || nums.length == 0) { return; }
        
        int rshift = 0;
        if (k < 0) {
            rshift = nums.length - (-1*k)%nums.length;
        } else {
            rshift = k%nums.length;
        }
        
        for (int i = 0; i < nums.length; i++) {
            temp[(i+rshift)%nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    // slow version, using O(1) space
    public void rotate1(int[] nums, int k)
    {
        // if nums is null or empty, do nothing
        if(nums == null || nums.length == 0) { return; }
        
        int rshift = 0;
        if(k < 0) {
            rshift = nums.length - (-1*k)%nums.length;
        } else {
            rshift = k%nums.length;
        }
        
        // for each of the staring point, rshift of them
        for(int i = 0; i < rshift; i++) {
            int prev = nums[0];
            int save = nums[0];
            for(int idx = 0; idx < nums.length; idx++) {
                int next = (idx+1)%nums.length;
                save = nums[next];
                nums[next] = prev;
                prev = save;
            }
        }
    }
}
