import java.io.*;
import java.util.*;


class PalindromeNumber
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        
        int num = 1234325;
        //int num = -1;
        boolean result = solution.isPalindrome(num);
        
        System.out.println("num = "+num);
        System.out.println("isPalindrome = "+result);
    }
}


class Solution
{
    public boolean isPalindrome(int x)
    {
        // if x is < 0, return false
        // we assume negative numbers are NOT palindrome
        if(x < 0) { return false; }

        int num_digits = 0;

        int temp = x>=0 ? x:(-1*x);
        while(temp > 0)
        {
            num_digits += 1;
            temp = temp/10;
        }
        //System.out.println("num_digits = "+num_digits);

        temp = x>=0 ? x:(-1*x);
        for(int i = 0; i < Math.ceil(num_digits/2); i++)
        {
            // get the i-th digit from left
            int left_digit = ((int)(temp/Math.pow(10, num_digits-(i+1))))%10;
            

            // get the i-th digit from right
            int right_digit = ((int)(temp/Math.pow(10, i)))%10;

            //System.out.println("left_digit = "+left_digit);
            //System.out.println("right_digit = "+right_digit);
            
            if(left_digit != right_digit) { return false; }
        }


        return true;
    }
}
