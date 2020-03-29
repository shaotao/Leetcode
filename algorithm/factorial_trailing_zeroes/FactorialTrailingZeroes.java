import java.io.*;
import java.util.*;


class FactorialTrailingZeroes
{
    public static void main(String[] args)
    {
        System.out.println("=== Factorial Trailing Zeroes ===");
        Solution solution = new Solution();
        int[] input = {1, 5, 10, 15, 20, 50, 100, 150, 200, 250, 300, 350, 400, 600, 800, 1000};
        for(int n: input) {
            int result = solution.trailingZeroes(n);
            System.out.println("n = "+n+", factorial(n)'s number of trailing zeroes = "+result);
        }
    }
}

class Solution
{
    public int trailingZeroes(int n)
    {
        int k = (int)(Math.log(n)/Math.log(5));
        int num = 0;
        int count = 0;
        for (int i = k; i >= 1; i--) {
            int local_num = (int) ((n/Math.pow(5, i)) - count);
            num += local_num*i;
            count += local_num;
        }

        return num;
    }
}
