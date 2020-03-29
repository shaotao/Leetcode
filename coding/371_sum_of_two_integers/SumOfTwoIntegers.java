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
        System.out.println("2 + 3 = "+solution.getSum(2, 3));
        System.out.println("1 + (-2) = "+solution.getSum(1, -2));
        System.out.println("2147483647 + (-2147483648) = "+solution.getSum(2147483647, -2147483648));
    }
}


class Solution
{
    public int getSum(int a, int b) {
        int ret = 0;

        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);

        //System.out.println(aStr);
        //System.out.println(bStr);
        
        boolean carry = false;

        String out = "";
        for (int i = 1; i <= 32; i++) {
            int va = 0;
            int vb = 0;

            if (i > aStr.length() && i > bStr.length() && !carry) {
                break;
            }
            if (aStr.length() >= i) {
                va = aStr.charAt(aStr.length()-i)=='0'?0:1;
            } else {
                va = 0;
            }

            if (bStr.length() >= i) {
                vb = bStr.charAt(bStr.length()-i)=='0'?0:1;
            } else {
                vb = 0;
            }
            //System.out.println("out = "+out+", va = "+va+", vb = "+vb);

            if(va + vb == 0) {
                if(carry) {
                    out = "1"+out;
                    carry = false;
                } else {
                    out = "0"+out;
                }
            } else if (va + vb == 1) {
                if(carry) {
                    out = "0"+out;
                    carry = true;
                } else {
                    out = "1"+out;
                    carry = false;
                }
            } else {
                if(carry) {
                    out = "1"+out;
                } else {
                    out = "0"+out;
                }
                carry = true;
            }
        }

        if (out.length() == 32 && out.charAt(0) == '1') {
            out = "-" + out.substring(1);
        }
        
        ret = Integer.valueOf(out, 2);
        
        return ret;
    }
}
