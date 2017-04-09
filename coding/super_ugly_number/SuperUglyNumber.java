import java.io.*;
import java.util.*;


class SuperUglyNumber
{
    public static void main(String[] args)
    {
        System.out.println("=== Super Ugly Number ===");
        Solution solution = new Solution();
        int[] primes = {2, 7, 13, 19};
        int n = 12;

        System.out.println("primes = "+Arrays.toString(primes));
        for(int i = 1; i <= 12; i++) {
            System.out.println(i+") "+solution.nthSuperUglyNumber(i, primes));
        }
    }
}

class Solution
{
    public int nthSuperUglyNumber(int n, int[] primes)
    {
        int ret = 0;
        return ret;
    }
}
