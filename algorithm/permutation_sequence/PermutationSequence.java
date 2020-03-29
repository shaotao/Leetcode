import java.io.*;
import java.util.*;


class PermutationSequence
{
    public static void main(String[] args)
    {
        System.out.println("=== Permutation Sequence ===");
        
        int n = 3;
        int k = 4;
        
        Solution solution = new Solution();
        String result = solution.getPermutation(n, k);
        
        System.out.println("n = "+n+", k = "+k);
        System.out.println("result = "+result);
    }
}


class Solution
{
    public Solution()
    {
    }

    public int factorial(int n)
    {
        if(n <= 1)
        {
            return 1;
        }
        
        int result = 1;

        for(int i = 1; i <= n; i++)
        {
            result *= i;
        }

        return result;
    }

    public String getPermutation(int n, int k)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
        {
            nums.add(i);
        }
        
        String result = "";
        
        // identify the n numbers at position 1..n
        for(int i = 0; i < n; i++)
        {
            int width = factorial(n-(i+1));

            int idx = (k-1)/width;
            if(idx < 0)
            {
                idx = 0;
            }
            
            // take the number at idx
            result += nums.get(idx);
            nums.remove((int)idx);
            
            k -= idx* width;
        }

        return result;
    }
}
