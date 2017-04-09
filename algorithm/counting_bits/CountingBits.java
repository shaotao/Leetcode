import java.io.*;
import java.util.*;


class CountingBits
{
    public static void main(String[] args)
    {
	System.out.println("=== Counting Bits ===");
	Solution solution = new Solution();
        int num = 5;
        int[] ret = solution.countBits(num);

        System.out.println("num = "+num+", bits = "+Arrays.toString(ret));
    }
}


class Solution
{
    public int[] countBits(int num) {
        int[] ret = new int[num+1];

        for(int i = 0; i <= num; i++) {
            int count = 0;
            int temp = i;
            while(temp > 0) {
                if ((temp & 1) == 1) { count++; }
                temp>>=1;
            }

            ret[i] = count;
        }

        return ret;
    }
}
