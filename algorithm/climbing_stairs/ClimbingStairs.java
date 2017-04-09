import java.io.*;
import java.util.*;


class ClimbingStairs
{
    public static void main(String[] args)
    {
        int n = 10;
        Solution solution = new Solution();

        int result = solution.climbStairs(n);

        System.out.println("=== Climbing Stairs ===");
        System.out.println("n = "+n+", result = "+result);
    }
}

class Solution
{
    public int climbStairs(int n)
    {
        if(n <= 2)
        {
            return n;
        }
        else
        {
            int a = 1;
            int b = 2;
            for(int i = 3; i <= n; i++)
            {
                int temp = b;
                b += a;
                a = temp;
            }

            return b;
        }
    }
}
