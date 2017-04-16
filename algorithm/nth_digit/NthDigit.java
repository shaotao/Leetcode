import java.io.*;
import java.util.*;


class NthDigit
{
    public static void main(String[] args)
    {
	System.out.println("=== Nth Digit ===");
	Solution solution = new Solution();

        int[] nums = {1, 3, 11, 123, 1000};
        for(int n: nums) {
            System.out.println("n = "+n+", nth digit = "+solution.findNthDigit(n));
        }
    }
}


class Solution
{
    public int findNthDigit(int n) {
        int ret = 0;
        int sum = 0;
        int numDigits = 0;
        while(sum < n) {
            sum += (numDigits+1)*9*Math.pow(10, numDigits);
            numDigits++;
        }

        int gap = 0;
        for(int i = 0; i < numDigits-1; i++) {
            gap += 9*Math.pow(10, i)*(i+1);
        }

        int num = (n - gap-1)/numDigits+(int)(Math.pow(10, numDigits-1));
        //System.out.println("gap = "+gap);
        //System.out.println("numDigits = "+numDigits);
        //System.out.println("num = "+num);

        int left = n - gap;
        int idx = left%numDigits;

        if(idx == 0) {
            // last digit on the right
            ret = num%10;
        } else {
            // first, second, .. digit
            String str = Integer.toString(num);
            ret = Integer.parseInt(""+str.charAt(idx-1));
        }
        
        return ret;
    }
}
