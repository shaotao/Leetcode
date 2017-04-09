import java.io.*;
import java.util.*;


class NumberOfDigitOne
{
    public static void main(String[] args)
    {
	System.out.println("=== Number of Digit One ===");
	Solution solution = new Solution();

        int[] nums = {13, 27, 100, 1000, 10000, 123456, 1410065408};
        for(int num: nums) {
            System.out.println("n = "+num+", number of ones = "+solution.countDigitOne(num)+", verify = "+verify(num));
        }
    }

    public static int verify(int n) {

        if(n > 100000000) { return -1; }
        
        int count = 0;
        if(n <= 0) { return 0; }

        for(int i = 1; i <= n; i++) {
            String s = i+"";
            for(int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '1') {
                    count++;
                }
            }
        }

        return count;
    }
}


class Solution
{
    public int countDigitOne(int n) {
        int count = 0;
        if(n <= 0) { return 0; }
        
        for(int i = 0; i < 32; i++) {

            long divisor = (long)(Math.pow(10, i));
            long b = (n % divisor);
            long a = (n / (10*divisor));

            long x = (n/divisor)%10;

            if (x == 0) {
                count += a*divisor;
            } else if (x == 1) {
                count += a*divisor+(b+1);
            } else {
                count += (a+1)*divisor;
            }

            if(a == 0) { break; }
        }

        return count;
    }
}
