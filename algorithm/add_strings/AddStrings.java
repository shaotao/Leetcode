import java.io.*;
import java.util.*;


class AddStrings
{
    public static void main(String[] args)
    {
	System.out.println("=== Add Strings ===");
	Solution solution = new Solution();

        String num1 = "1234567890";
        String num2 = "9876543210";

        System.out.println("num1 = "+num1);
        System.out.println("num2 = "+num2);
        System.out.println("num1 + num2 = "+solution.addStrings(num1, num2));
    }
}


class Solution
{
    public String addStrings(String num1, String num2) {
        StringBuffer buf = new StringBuffer();

        int len1 = num1.length();
        int len2 = num2.length();

        int len = (len1 > len2)?len1:len2;
        int carry = 0;
        for(int i = 0; i < len; i++) {
            int a = 0;
            if(i < len1 ) { a = num1.charAt(len1-1-i) - '0'; }
            int b = 0;
            if(i < len2 ) { b = num2.charAt(len2-1-i) - '0'; }
            int sum = a+b+carry;

            int val = sum%10;
            buf.insert(0, val);
            carry = sum/10;
        }

        if(carry > 0) { buf.insert(0, carry); }
        
        return buf.toString();
    }
}
