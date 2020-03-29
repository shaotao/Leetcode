import java.io.*;
import java.util.*;


class PowerOfFour
{
    public static void main(String[] args)
    {
	System.out.println("=== Power Of Four ===");
	Solution solution = new Solution();

        int[] array = {16, 4, 5, 8};
        for(int n:array) {
            System.out.println("isPowerOfFour("+n+") = "+solution.isPowerOfFour(n));
        }
    }
}


class Solution
{
    public boolean isPowerOfFour(int num) {
        if(num <= 0) { return false; }
        int k = (int)(Math.log(num)/Math.log(4));

        return num == Math.pow(4, k);
    }
}
