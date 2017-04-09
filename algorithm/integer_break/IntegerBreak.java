import java.io.*;
import java.util.*;


class IntegerBreak
{
    public static void main(String[] args)
    {
	System.out.println("=== Integer Break ===");
	Solution solution = new Solution();

        for(int i = 2; i <= 10; i++) {
            System.out.println("integerBreak("+i+") = "+solution.integerBreak(i));
        }
    }
}


class Solution
{
    public int integerBreak(int n) {        
        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for(int i = 3; i <= n; i++) {
            int max = 0;
            for(int j = 1; j <= i/2; j++) {
                int tmp = array[j]*array[i-j];
                max = (tmp > max)?tmp:max;

                tmp = j*array[i-j];
                max = (tmp > max)?tmp:max;
                
                tmp = array[j]*(i-j);
                max = (tmp > max)?tmp:max;
                
                tmp = j*(i-j);
                max = (tmp > max)?tmp:max;
            }

            array[i] = max;
        }

        return array[n];
    }
}
