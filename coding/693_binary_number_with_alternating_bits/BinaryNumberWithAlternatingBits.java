import java.io.*;
import java.util.*;


class BinaryNumberWithAlternatingBits
{
    public static void main(String[] args)
    {
        System.out.println("=== Binary Number with Alternating Bits ===");
        Solution solution = new Solution();
        int[] nums = {5,7,11,10};
        for(int n: nums) {
            System.out.println(n+": "+solution.hasAlternatingBits(n));
        }
    }
}


class Solution
{
    public boolean hasAlternatingBits(int n) {
        int prev = n%2;
        n = n/2;
        while(n > 0) {
            if(n%2 == prev) {
                return false;
            }
            prev = n%2;
            n = n/2;
        }

        return true;
    }
}
