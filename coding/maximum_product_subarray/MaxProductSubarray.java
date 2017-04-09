import java.io.*;
import java.util.*;

class MaxProductSubarray
{
    public static void main(String[] args)
    {
        System.out.println("=== Maximum Proudct Subarray ===");
        int[] A = {2, 3, -2, 4};

        Solution solution = new Solution();

        int result = solution.maxProduct(A);

        System.out.print("A: ");
        for(int i = 0; i < A.length; i++)
        {
            System.out.print(A[i]+", ");
        }
        System.out.println();
        
        System.out.println("max product = "+result);
    }
}

class Solution
{
    public int maxProduct(int[] A)
    {
        int result = 0;

        //result = find_max(A, 0, A.length-1);
        result = maxProduct2(A);
        
        return result;
    }
    
    public int find_max(int[] A, int start_idx, int end_idx)
    {
        int result = 0;

        if(start_idx < 0 || end_idx >= A.length || start_idx > end_idx)
        {
            System.out.println("invalid index! A.length = "+A.length+", start_idx = "+start_idx+", end_idx = "+end_idx);
            return -1;
        }

        int self_idx = (start_idx + end_idx)/2;

        int left = 0;
        int right = 0;

        int self = A[self_idx];

        System.out.println("self = "+self);


        if(self_idx > start_idx) {
            left = find_max(A, start_idx, self_idx-1);
            if(self_idx < end_idx) {
                right = find_max(A, self_idx+1, end_idx);
                
                result = left;
                if(result < self) { result = self; }
                if(result < right) { result = right; }
                if(result < left*self) { result = left*self; }
                if(result < left*self*right) { result = left*self*right; }
                if(result < self*right) { result = self*right; }
            } else {
                result = left;
                if(result < self) { result = self; }
                if(result < left*self) { result = left*self; }
            }
        } else {
            if(self_idx < end_idx) {
                right = find_max(A, self_idx+1, end_idx);
                result = self;
                if(result < right) { result = right; }
                if(result < self*right) { result = self*right; }
            } else {
                result = self;
            }
        }

        System.out.println("max: A["+start_idx+", "+end_idx+"] = "+result);
        
        return result;
    }
    
    public int maxProduct2(int[] A)
    {
        int result = 0;        
        int size = A.length;

        if(size == 0)
        {
            return 0;
        }
        
        result = A[0];
        int temp = 0;
        for(int i = 0; i < size; i++)
        {
            temp = 1;
            for(int j = i; j < size; j++)
            {
                temp *= A[j];
                result = (temp>result)?temp:result;
            }
        }

        return result;
    }
}
