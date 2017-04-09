import java.io.*;
import java.util.*;


class PowerOfThree
{
    public static void main(String[] args)
    {
	System.out.println("=== Power of Three ===");
	Solution solution = new Solution();

        for(int i = 1; i <= 100; i++) {
            System.out.println("i = "+i+", is_power_of_3 = "+solution.isPowerOfThree(i));
        }
    }
}


class Solution
{
    public boolean isPowerOfThree(int n) {

        if(n <= 0) { return false; }
        
        while(n > 0 && n%3 == 0) {
            n /= 3;
        }

        return (n == 1);
    }
}
