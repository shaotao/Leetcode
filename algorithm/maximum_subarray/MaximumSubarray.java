import java.io.*;
import java.util.*;


class MaximumSubarray
{
    public static void main(String[] args)
    {
        System.out.println("=== Maximum Subarray ===");
        Solution solution = new Solution();
        
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int max_sum = solution.maxSubArray(A);
        
        System.out.println("max sum = "+max_sum);
    }
}

class Solution
{
    public int maxSubArray(int[] A)
    {
        if(A.length == 0) { return 0; }
        
        int max_end_here = A[0];
        int max = A[0];

        for(int i = 1; i < A.length; i++)
        {
            max_end_here = (A[i]>max_end_here+A[i])? A[i] : (max_end_here+A[i]);
            max = max_end_here > max ? max_end_here : max;
        }
        
        return max;
    }
}

