import java.io.*;
import java.util.*;


class SumOfTwoIntegers
{
    public static void main(String[] args)
    {
	System.out.println("=== Sum Of Two Integers ===");
	Solution solution = new Solution();

        System.out.println("1 + 2 = "+solution.getSum(1, 2));
        System.out.println("12345 + 678 = "+solution.getSum(12345, 678));
        System.out.println("1 + (-2) = "+solution.getSum(1, -2));
    }
}


class Solution
{
    public int getSum(int a, int b) {

        int ret = 0;
        
        int bit = 0;
        int carry = 0;
        int pos = 0;
        while(a != 0 && b != 0) {
            System.out.println("a = "+a+", b = "+b);
            int bit_sum = (a & 1) + (b & 1);
            if(bit_sum == 2) {
                bit = carry;
                carry = 1;
            } else if (bit_sum == 1) {
                bit = carry^1;
            } else {
                bit = 0;
                carry = 0;
            }

            System.out.println("bit = "+bit);
            ret += (bit<<pos);

            a = (a>>1);
            b = (b>>1);

            System.out.println("a = "+a);
            System.out.println("b = "+b);
            pos++;
        }

        // check if a or b is left to be != 0
        int left = (a!=0)?a:b;
        while(left != 0) {
            System.out.println("left = "+left);
            ret += ((left & 1)<<pos);
            left = (left>>1);
            pos++;
        }
        
        return ret;
    }
    
    public int getSum2(int a, int b) {
        double s1 = Math.pow(10, a);
        double s2 = Math.pow(10, b);

        int ret = (int)(Math.log10(s1*s2));

        return ret;
    }
}
