import java.io.*;
import java.util.*;


class NumberOf1Bits
{
    public static void main(String[] args)
    {
        System.out.println("=== Number of 1 Bits ===");
        Solution solution = new Solution();
        int n = 11;
        int result = solution.hammingWeight(n);
        System.out.println("number of 1s in "+n+" is: "+result);
    }
}


class Solution
{
    public int hammingWeight(int n)
    {
        int count = 0;
        for(int i = 0; i < 32; i++)
        {
            count += n & 1;
            n = n >>1;
        }
        
        return count;
    }
}
