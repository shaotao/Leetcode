import java.io.*;
import java.util.*;


class IntegerReplacement
{
    public static void main(String[] args)
    {
	System.out.println("=== Integer Replacement ===");
	Solution solution = new Solution();

        int[] input = {3, 8, 7, 10, 65535, 100000000};
        for(int n:input) {
            System.out.println("n = "+n+", steps = "+solution.integerReplacement(n));
        }
    }
}


class Solution
{
    public int integerReplacement(int n) {
        return trace(n);
    }

    public int trace(long n) {
        if (n == 1) { return 0; }

        if ((n & 1) == 0) { return 1 + trace(n>>1); }
        int up = 1+trace(n+1);
        int down = 1+trace(n-1);

        return up<down?up:down;
    }
}
