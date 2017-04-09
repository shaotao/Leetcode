import java.io.*;
import java.util.*;


class FindMin
{
    public static void main(String[] args)
    {
        System.out.println("=== Find Minimum in Rotated Sorted Array ===");

        int[] num = {4, 5, 6, 7, 0, 1, 2};
        Solution solution = new Solution();
        
        int result = solution.findMin(num);
        System.out.print("array = ");
        for(int i = 0; i < num.length; i++)
        {
            System.out.print(num[i]+", ");
        }
        System.out.println();
        System.out.println("min = "+result);
    }
}


class Solution
{
    public int findMin(int[] num)
    {
        int idx = 0;
        
        if(num.length == 0) 
        { 
            System.out.println("Solution.findMin() error: invalid num.length = "+num.length);
            return 0; 
        }
        
        int left = 0;
        int right = num.length-1;
        idx = (left+right)/2;
        
        while(left < right)
        {
            idx = (left+right)/2;

            if(right - left == 1)
            {
                return (num[left]<num[right])?num[left]:num[right];
            }
            
            if(num[idx] < num[right]) { right = idx; }
            else { left = idx; }
            
            System.out.println("left = "+left+", right = "+right+", idx = "+idx);
        }
         
        return num[idx];
    }
}
