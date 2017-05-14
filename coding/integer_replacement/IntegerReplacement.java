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
    // n is a positive integer
    public int integerReplacement(int n) {
        if(n < 1) { return 0; }

        int size = 5;
        if(n <= 4) { size = 5; }
        else { size = n+1; }
        int[] array = new int[size];
        array[0] = 0;
        array[1] = 0;
        array[2] = 1;
        array[3] = 2;
        array[4] = 2;

        for(int i = 5; i <= n; i++) {
            if(i%2 == 1) {
                int a = array[(i+1)/2];
                int b = array[(i-1)/2];

                int target = (a<b)?a:b;

                array[i] = 2+target;
                
            } else {
                array[i] = 1+array[i/2];
            }
        }

        return array[n];
    }
}
