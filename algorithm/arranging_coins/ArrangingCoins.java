import java.io.*;
import java.util.*;


class ArrangingCoins
{
    public static void main(String[] args)
    {
	System.out.println("=== Arranging Coins ===");
	Solution solution = new Solution();

        int n = 10;
        for(int i = 0; i <= n; i++)
        {
            System.out.println("n = "+i+", arrangeCoins = "+solution.arrangeCoins(i));
        }

        n = 1804289383;
        System.out.println("n = "+n+", arrangeCoins = "+solution.arrangeCoins(n));
        
    }
}


class Solution
{
    public int arrangeCoins(int n)
    {
        double tmp = n;
        return ((int)Math.floor((Math.sqrt(1+8*tmp)-1)/2));
    }
}
